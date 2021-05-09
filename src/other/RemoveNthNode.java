package other;

public class RemoveNthNode {


    private static int getNthValueFromStart(Node head, int n){
        int count=n;
        while(count>1){
            head=head.next;
            count--;
        }
        return head.value;
    }

    private static int getNthNodeFromEnd(Node head, int n){
        Node p1=head, p2=head;
        for(int i=0;i<n;i++){
            p1=p1.next;
        }
        System.out.println("p1 moved to "+p1.value);
        while (p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2.value;
    }
    private static Node removeNthNodeFromEnd(Node head, int n){
        Node p1=head, p2=head;
        //move p1 ahead of p2 by n hops
        for(int i=0;i<n;i++){
            if(p1.next==null){
                //we have crossed the last node in list;
                if(i==n-1){
                    head=head.next;
                }
                return head;
            }
            p1=p1.next;
        }
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p2.next=p2.next.next;
        return head;
    }
    public static void main(String[] args) {
        Node n = new Node(1);
       n.next= new Node(2);
/*        n.next.next.next= new Node(4);
        n.next.next.next.next= new Node(5);*/

       // System.out.println("3rd node from start: "+RemoveNthNode.getNthValueFromStart(n,3));
      //  System.out.println("2nd node from last: "+RemoveNthNode.getNthNodeFromEnd(n,2));

        Node head = RemoveNthNode.removeNthNodeFromEnd(n,2);
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }

    }

    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
            next=null;
        }
    }
}
