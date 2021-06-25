package kwaymerge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Node{
    int listIndex;
    int elementIndex;
    Node(int listIndex, int elementIndex){
        this.elementIndex = elementIndex;
        this.listIndex = listIndex;
    }
}
public class KthSmallestInMSortedArrays {
    public static int findKthSmallest(List<Integer[]> lists, int k) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparing(node -> lists.get(node.listIndex)[node.elementIndex]));
        for(int i=0; i< lists.size();i++)
        {
            minHeap.add(new Node(i,0));

        }
        int count = 0;
        while(!minHeap.isEmpty()){
            Node node = minHeap.remove();
            if(++count==k)
                return lists.get(node.listIndex)[node.elementIndex];
            if(lists.get(node.listIndex).length > node.elementIndex ){
                minHeap.add(new Node(node.listIndex, ++node.elementIndex));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
