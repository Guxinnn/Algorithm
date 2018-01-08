/**
 * Created by Doodle on 9/26/17.
 */

import leetcode.Tree.TreeNode;

public class RecoverFromPreorder {
    public TreeNode recover(int[] arr) {
        return recover(arr, 0, arr.length-1);
    }

    private TreeNode recover(int[] arr, int lo, int hi) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(arr[lo]);

        int index = hi+1;
        for (int i = lo+1; i <= hi; i++) {
            if (arr[i] > root.val) {
                index = i;
                break;
            }
        }

        root.left = recover(arr, lo+1, index-1);
        root.right = recover(arr, index, hi);

        return root;
    }

    private void printInOrder(TreeNode node) {
        if(node == null) return;
        printInOrder(node.left);
        System.out.println(node.val);
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        RecoverFromPreorder r = new RecoverFromPreorder();
        int[] arr = {10, 7, 5, 9, 8, 15, 12};
        TreeNode res = r.recover(arr);
        r.printInOrder(res);
    }
}
