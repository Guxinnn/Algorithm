package leetcode.Tree;
import java.util.*;
/**
 * Created by Doodle on 9/15/17.
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, "", list);
        return list;
    }

    public static void helper(TreeNode node, String path, List<String> ans) {
        if(node.left == null && node.right == null) ans.add(path + node.val);
        if(node.left == null && node.right != null) {
            helper(node.right, path + node.val + "->", ans);
        }
        if(node.right == null && node.left != null) {
            helper(node.left, path + node.val + "->", ans);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(binaryTreePaths(root));
    }
}
