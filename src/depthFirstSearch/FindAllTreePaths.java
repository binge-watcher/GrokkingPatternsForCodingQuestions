package depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPath(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPath(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        // add the current node to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPath(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            // traverse the right sub-tree
            findPath(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

    static List<List<Integer>> findAllPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, currentPath, allPaths);
        return allPaths;
    }

    private static void findPaths(TreeNode root, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null)
            return;

        currentPath.add(root.val);
        if (root.left == null & root.right == null)
            allPaths.add(new ArrayList<>(currentPath));

        findPaths(root.left, currentPath, allPaths);
        findPaths(root.right, currentPath, allPaths);

        currentPath.remove(currentPath.size() - 1);
    }

    static List<Integer> findMaxPath(TreeNode root) {
        //  List<Integer> allPaths = null;
        List<Integer> currentPath = new ArrayList<>();
        int max = Integer.MIN_VALUE, sum = 0;
        findmax(root, sum, currentPath);
        return allPaths;
    }

    private static int max = Integer.MIN_VALUE;
    private static List<Integer> allPaths;

    private static void findmax(TreeNode root, int sum, List<Integer> currentPath) {
        if (root == null)
            return;

        currentPath.add(root.val);
        sum = sum + root.val;
        if (root.left == null && root.right == null && sum > max) {
            max = sum;
            allPaths = new ArrayList<>(currentPath);
        } else {
            findmax(root.left, sum, currentPath);
            findmax(root.right, sum, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }


}
