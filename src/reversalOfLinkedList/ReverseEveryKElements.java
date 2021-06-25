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
        Node head = ReverseEveryKElements.reverseAgain(node,3);
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }

    }

    //1->2->3->4->5->6->7
    // 1<-2<-3 4
    // 3->2->1  ->4->5->6
    //reverse
    // attach left to start
    // attach right to end
    private static Node reverseAgain(Node node, int k) {
        Node head = node;
        Node prev=null, next;
        Node endOfsublist;
        Node startOfsublist;
        Node previousEnd=null;
        while(node!=null){
            endOfsublist=node;
            for(int i=1;i<=k;i++){
                next=node.next;
                node.next=prev;
                prev=node;
                node=next;
            }
            if(previousEnd!=null){
                previousEnd.next = prev;
            }
            endOfsublist.next=node;
            previousEnd = endOfsublist;
        }

        return node;

    }
}

