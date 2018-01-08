package leetcode.Tree;

/**
 * Created by Doodle on 9/15/17.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {val = x;}

    public void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.println(node.val + " ");
        printInOrder(node.right);
    }
}
