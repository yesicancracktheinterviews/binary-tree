package Binary_Tree_Root_To_Leaf_Path;

import java.util.LinkedList;
import java.util.List;


/**   Recursion
 *  One is going through the tree by considering at each step the node itself and its children.
 *  If node is not a leaf, one extends the current path by a node value and calls recursively the path construction for its children.
 * TC: O(N)  since each node is visited exactly once
 * SC: O(N)
 */

        import java.util.*;
public class Solution {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println("Output: \n" + binaryTreePaths(root));
    }

    static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        int step =1;
        if (root == null)
            return paths;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        System.out.println(("Step " +step + " Root Node Value " + root.val));
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;

        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))  // You reached to the leaf
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                step++;
                System.out.println(("Step " +step + " Left Node Value " + node.left.val));
                path_stack.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                node_stack.add(node.right);
                step++;
                System.out.println(("Step " +step + " Right Node Value " + node.right.val));
                path_stack.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}
