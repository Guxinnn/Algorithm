package Company.IXL;

import leetcode.Tree.*;
import java.util.*;
/**
 * Created by Doodle on 2/3/18.
 */
public class BT2BST {
    private static int pos = 0;

    public TreeNode btToBST(TreeNode root) {
        int count = countNodes(root);
        int[] arr = new int[count];

        addNodeInorder(root, arr);
        Arrays.sort(arr);
        root = sortedArrayToBST(arr, 0, arr.length-1);
        return root;
    }

    private TreeNode sortedArrayToBST(int[] array, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(array[mid]);

        node.left = sortedArrayToBST(array, start, mid-1);
        node.right = sortedArrayToBST(array, mid+1, end);
        return node;
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private void addNodeInorder(TreeNode root, int[] array) {
        if (root == null) return;

        array[pos++] = root.val;
        addNodeInorder(root.left, array);
        addNodeInorder(root.right, array);
    }

    public static void main(String[] args) {
        BT2BST b = new BT2BST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int counts = b.countNodes(root);
        int[] arr = new int[counts];

        b.addNodeInorder(root, arr);
        System.out.println(Arrays.toString(arr));
    }

}
