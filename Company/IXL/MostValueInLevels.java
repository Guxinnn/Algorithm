package Company.IXL;

import java.util.*;

/**
 * Created by Doodle on 2/4/18.
 */
public class MostValueInLevels {
    public String findValue(TreeStringNode root) {
        if (root == null) return null;

        Queue<TreeStringNode> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        q.offer(root);
        String res = "";
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            set.clear();

            for (int i = 0; i < size; i++) {
                TreeStringNode node = q.poll();
                set.add(node.s);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            for (String str : set) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = entry.getKey();
                max = entry.getValue();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MostValueInLevels m = new MostValueInLevels();

        TreeStringNode root = new TreeStringNode("cat");
        root.left = new TreeStringNode("dog");
        root.right = new TreeStringNode("cat");

        System.out.println(m.findValue(root));
    }
}
