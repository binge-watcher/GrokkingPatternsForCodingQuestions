package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

class Treenode {
    int val;
    Treenode left;
    Treenode right;
    Treenode next;

    Treenode(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        Treenode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            Treenode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};
public class ConnectLevelOrderSiblings {
    public static void connect(Treenode root) {
        Queue<Treenode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Treenode previous=null;
            for(int i=0;i<size;i++){
                Treenode node = queue.poll();
                if(previous!=null){
                    previous.next=node;
                }
                previous=node;
              //  System.out.print(node.val+" ");
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }

        }
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(12);
        root.left = new Treenode(7);
        root.right = new Treenode(1);
        root.left.left = new Treenode(9);
        root.right.left = new Treenode(10);
        root.right.right = new Treenode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
