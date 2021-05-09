package reversalOfLinkedList;

public class RotateList {


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next  = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        Node head = RotateList.rotate(node,3);
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }

    }

    private static Node rotate(Node node, int numberOfRotations) {
        Node head = node;
        int length=0;

        while(node.next!=null){
            node=node.next;
            length++;
        }
        Node tail = node;

        numberOfRotations %= length;

        tail.next=head;

        Node current=head, previous=null;
        for(int i=0;i<numberOfRotations;i++){
            previous=current;
            current=current.next;
        }

        previous.next=null;
        head=current;

        return head;

    }
}
