package fastAndSlowPointers;



public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
       if(head==null|| head.next==null){
           return false;
       }
       Node slow=head, fast=head;
       while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(fast==slow)
               return true;
       }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
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
