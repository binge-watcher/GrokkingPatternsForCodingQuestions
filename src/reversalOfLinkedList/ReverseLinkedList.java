package reversalOfLinkedList;

public class ReverseLinkedList {


    private static Node reverse(Node head){
        Node current = head;
        Node previous = null, next;

        while(current!=null){
            next = current.next;  // move "next" to point to next reversalOfLinkedList.Node after "current"
            current.next = previous;  // "cuurent" pointer is reversed
            previous = current;  // "previous moves forward to "current"
            current = next;     // "current" moves forward
        }
        return previous;
    }


    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(4);
        node.next.next = new Node(6);
        node.next.next.next = new Node(8);
        node.next.next.next.next = new Node(10);

        Node newHead = reverse(node);

        while (newHead!=null){
            System.out.print(newHead.value+" ");
            newHead = newHead.next;
        }

    }



}
