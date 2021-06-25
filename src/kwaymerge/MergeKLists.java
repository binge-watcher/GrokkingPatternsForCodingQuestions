package kwaymerge;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

/*
Time complexity - adding and removing elemetns from priority queeu is o(logn), where n is the size of the queue
so we add  'N' total nodes to a queue of size K so time complexity - N*log(k)
space complexity - linked list - O(N) and heap - O(K)
 */
public class MergeKLists {
    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing(ListNode->ListNode.value));
        for(ListNode node: lists){
            if(node!=null)
                minHeap.add(node);
        }
        ListNode head = null, tail = null;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.remove();

            if(head==null){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            if(node.next!=null){
                minHeap.add(node.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
