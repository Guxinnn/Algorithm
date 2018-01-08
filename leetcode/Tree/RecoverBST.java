import Tree.TreeNode;

public class RecoverBST {
    private int pIndex = 0;

    public TreeNode constructTree(int[] preorder, int data, int min, int max) {
        if (pIndex >= preorder.length) return null;

        TreeNode root = null;

        if (pIndex < preorder.length) {
            if (preorder[pIndex] > min && preorder[pIndex] < max) {
                root = new TreeNode(data);
                pIndex++;
                if (pIndex < preorder.length) {
                    root.left = constructTree(preorder, preorder[pIndex], min,
                            data);
                    root.right = constructTree(preorder, preorder[pIndex],
                            data, max);
                }
            }
        }
        return root;
    }

    public void printInorder(TreeNode root) {
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String args[]) {
        RecoverBST tree = new RecoverBST();
        int[] preOrder = { 10, 7, 5, 9, 8, 15 };
        TreeNode root = tree.constructTree(preOrder, preOrder[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        System.out.println("Inorder Traversal of Constructed Tree : ");
        tree.printInorder(root);
    }
}

