package other;

public class ReversalsLL {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
      //  head.next.next.next.next.next = new Node(6);
       // head.next.next.next.next.next.next = new Node(7);
        //head.next.next.next.next.next.next.next = new Node(8);
        //head.next.next.next.next.next.next.next.next = new Node(9);

       // Node h1 = ReversalsLL.justReverse(head);
      //  Node h1 = ReversalsLL.reverseSublist(head,4,5);
        Node h1 = ReversalsLL.reverseEveryKNodes(head,3);
      //  Node h1 = ReversalsLL.reverseEveryKElements(head,2);
        while (h1!=null){
            System.out.print(h1.val+" ");
            h1 = h1.next;
        }
    }

    static Node reverseEveryKElements(Node node, int k){
        Node head = node;
        Node prev=null,before;
        while(node!=null){
            before=prev;
            Node next=null;
            Node end = node;
            for(int i=1;node!=null && i<=k;i++){
                next=node.next;
                node.next=prev;
                prev=node;
                node=next;
            }
            if(before==null){
                head=prev;
            }else{
                before.next=prev;
            }
            end.next=node;

            for(int i=1;node!=null && i<=k;i++){
                prev=node;
                node=node.next;
            }
        }
        return head;
    }

    static Node reverseEveryKNodes(Node node, int k){
        Node head = node;
        Node prev=null,next=null;
        while (node!=null){
            Node end = node;
            Node beforeSublist = prev;
            // reverse between p and q
            for(int i=1;node!=null && i<=k;i++){
                next=node.next;
                node.next=prev;
                prev=node;
                node=next;
            }
            if(beforeSublist==null)
                head=prev;
            else{
                beforeSublist.next = prev;
            }
            end.next=node;
            prev=end;
        }
        return head;
    }

    static Node reverseSublist(Node node, int p , int q){
        if(p==q)
            return node;
        Node head = node;
        Node prev=null,next=null;
        //traverse till p
        for(int i=1;i<p;i++){
            prev=node;
            node = node.next;
        }
        Node end = node;
        Node beforeSublist = prev;

        // reverse between p and q
        for(int i=p;i<=q;i++){
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        Node afterSublist = node;
        Node start = prev;

        if(beforeSublist==null)
            head=prev;
        else{
            beforeSublist.next = start;
        }
        end.next=afterSublist;
        return head;
    }

    static Node justReverse(Node node){
        Node prev=null, next=null;
        while(node!=null){
            next = node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
}
