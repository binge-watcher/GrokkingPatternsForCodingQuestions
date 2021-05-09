package other;

public class RemoveLinkedListElements {
    public static Node removeElements(Node head, int val) {

        Node cur=head,prev=null;
        while(cur!=null){
            if(prev==null && cur.val==val){
                cur=cur.next;
                head=head.next;
            }
            if(cur.val==val){
                prev.next=prev.next.next;
                cur=cur.next;
              if(cur==null)
                  return head;
            }

            prev=cur;
            cur=cur.next;

        }
        return head;

    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next= new Node(2);
        n.next.next= new Node(3);
       n.next.next.next= new Node(4);
        n.next.next.next.next= new Node(5);
        Node head = RemoveLinkedListElements.removeElements(n,5);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    static class Node{
        int val;
        Node next;
        Node(int value){
            this.val=value;
            next=null;
        }
    }


}
