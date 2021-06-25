import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Queue<String> stack = new LinkedList<>();
        stack.add("apple");stack.add("mango");
        System.out.println(stack);
    }
}


class Super{
    void foo(){
        System.out.println("super");
        Collections.reverseOrder();
    }
}

