package fastAndSlowPointers;


// find middle
// reverse
// alternate
public class RearrangeList {


    public static void reorder(ListNode head) {
        ListNode save = head;
        // find middle
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        // reverse second half
        ListNode prev=null, next;
        while(middle!=null){
            next=middle.next;
            middle.next=prev;
            prev=middle;
            middle=next;
        }

        ListNode end= prev;
        while(end!=null && head!=null){
           ListNode temp = head.next;
           head.next=end;
           head = temp;

           temp = end.next;
           end.next = head;
           end = temp;

        }

        if (head != null) {
            head.next=null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
     //   head.next.next.next.next.next.next = new ListNode(20);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
