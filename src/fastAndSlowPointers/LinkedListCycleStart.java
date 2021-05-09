package fastAndSlowPointers;

public class LinkedListCycleStart {


    public static Node findCycleStart(Node head) {

        //find cycle exists
        //find length
        //move fast head + n nodes
        // move slow and fast together
        if(head==null|| head.next==null)
            return null;

        Node nodeInCycle = doesCycleExist(head);
        if(nodeInCycle==null)
            return null;

        int lengthOfCycle = findLengthOfCycle(nodeInCycle);
        Node slow=head, fast=head;
        while(lengthOfCycle>0){
            fast=fast.next;
            lengthOfCycle--;
        }
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    private static int findLengthOfCycle(Node nodeInCycle) {
        Node start = nodeInCycle;
        int count=0;
        do{
            start=start.next;
            count++;
        }while(start!=nodeInCycle);

        return count;
    }

    private static Node doesCycleExist(Node head) {
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }

    static private class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            next=null;
        }
    }
}
