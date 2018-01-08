package Tree;
import java.util.*;
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> idx = new HashMap<>(); // TreeNode and its column pair
        Map<Integer, List<Integer>> map = new HashMap<>(); // column and list of nodes

        queue.offer(root);
        idx.put(root, 0);
        int min = 0;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = idx.get(node);
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);

            if(node.left != null) {
                queue.add(node.left);
                idx.put(node.left, col-1);
            }

            if (node.right != null) {
                queue.add(node.right);
                idx.put(node.right, col+1);
            }

            min = Math.min(min, col);
        }

        while(map.containsKey(min)) {
            res.add(map.get(min));
            min++;
        }

        return res;
    }
}
