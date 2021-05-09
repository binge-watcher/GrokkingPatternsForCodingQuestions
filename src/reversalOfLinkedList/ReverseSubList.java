package reversalOfLinkedList;


public class ReverseSubList {

    public static Node reverse(Node head, int p, int q) {
      if(p==q)
          return head;

      Node current = head;
      Node previous = null;

      // get pth position and p-1th position
      for(int i=1; current!=null && i<p;i++){
            previous=current;
            current = current.next;
      }
      Node nodeBeforeSublist = previous;
      Node lastOfSublist = current;
      Node next;
      for(int i=0;i<q-p+1 && current!=null;i++){
          next=current.next;
          current.next=previous;
          previous=current;
          current=next;
      }
      if(nodeBeforeSublist==null)
        head=previous;
      else
          nodeBeforeSublist.next=previous;

      lastOfSublist.next=current;

      return head;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next  = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node head = ReverseSubList.reverse(node,1,4);
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }

    }

}
