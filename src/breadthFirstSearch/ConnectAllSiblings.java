package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    public static void connect(Treenode root) {
        Queue<Treenode> queue = new LinkedList<>();

        queue.offer(root);
        Treenode previous = null;
        while(!queue.isEmpty()){
            Treenode node = queue.poll();

            if(previous!=null){
                previous.next = node;
            }
            previous = node;

            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);

        }
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(12);
        root.left = new Treenode(7);
        root.right = new Treenode(1);
        root.left.left = new Treenode(9);
        root.right.left = new Treenode(10);
        root.right.right = new Treenode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        Treenode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
