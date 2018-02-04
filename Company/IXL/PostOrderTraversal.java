package Company.IXL;

import leetcode.Tree.*;
import java.util.*;
/**
 * Created by Doodle on 2/4/18.
 */
public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }

        Collections.reverse(res);
        return res;
    }
}
