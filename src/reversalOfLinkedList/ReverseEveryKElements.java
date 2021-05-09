package reversalOfLinkedList;

public class ReverseEveryKElements {

    static Node reverse(Node head, int k){
        boolean flag=true;

        Node current=head, previous=null, next;
        while(true){
            if(flag){
                Node nodeBeforeSublist = previous;
                Node lastOfSublist = current;

                for(int i=0;i<k && current!=null;i++){
                    next = current.next;
                    current.next=previous;
                    previous=current;
                    current=next;
                }

                if(nodeBeforeSublist!=null){
                    nodeBeforeSublist.next=previous;
                }
                else{
                    head=previous;
                }
                lastOfSublist.next=current;

                if(current==null)
                    break;
                previous=lastOfSublist;
                flag=!flag;

            }else{
                for(int i=0;i<k && current!=null; i++){
                    previous=current;
                    current = current.next;
                }
                flag=!flag;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next  = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        Node head = ReverseEveryKElements.reverse(node,3);
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }

    }
    }

