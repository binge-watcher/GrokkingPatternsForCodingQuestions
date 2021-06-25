package breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Treenode1 {
    int val;
    Treenode1 left;
    Treenode1 right;

    Treenode1(int x) {
        val = x;
    }
};

public class RightViewTree {

    public static List<Treenode1> traverse(Treenode1 root) {
        List<Treenode1> result = new ArrayList<>();
        Queue<Treenode1> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Treenode1 node = null;
            for(int i=0;i<size;i++){
                node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }


            result.add(node);
        }
        return result;
    }

    public static void main(String[] args) {
        Treenode1 root = new Treenode1(12);
        root.left = new Treenode1(7);
        root.right = new Treenode1(1);
        root.left.left = new Treenode1(9);
        root.right.left = new Treenode1(10);
        root.right.right = new Treenode1(5);
        root.left.left.left = new Treenode1(3);
        List<Treenode1> result = RightViewTree.traverse(root);
        for (Treenode1 node : result) {
            System.out.print(node.val + " ");
        }
    }
}
