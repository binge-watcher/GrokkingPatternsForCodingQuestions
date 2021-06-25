package reversalOfLinkedList;

// check if linkedlist is palindrome

// go to middle of list
// reverse link from middle to end of list
// compare node by node from start and end till you reach the middle.
// if nodes equal go to next node else false
// reverse list again to return to original state


public class PalindromicLinkedList {

    public static boolean isPalindrome(Node head) {
        if(head==null)
            return false;
        Node start = head;
        boolean result = false;
        Node middle = findMiddle(head);
        Node end = reverseSecondHalf(middle);
        result = compare(head, end);
        reverseSecondHalf(end);
        return result;
    }

    private static Node findMiddle(Node head) {
        Node slow=head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node reverseSecondHalf(Node middle) {
        Node current = middle;
        Node previous=null, next;
        while(current!=null){
            next = current.next;
            current.next = previous;
            previous=current;
            current = next;
        }
        return previous;
    }

    private static boolean compare(Node head, Node end) {
        Node first = head;
        Node second = end;

        while (first!=null && second!=null){
            if(first.value!=second.value)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(2);

        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
       // System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
    
}
