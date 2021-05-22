package depthFirstSearch;

public class TreePathSum {


    public static boolean hasPath(TreeNode root, int sum) {

        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return root.val == sum;

        int new_Sum = sum - root.val;

        return hasPath(root.left, new_Sum) || hasPath(root.right, new_Sum);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}
