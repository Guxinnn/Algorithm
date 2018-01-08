package Company.IXL;
import java.util.*;
/**
 * Created by Doodle on 2/3/18.
 */
public class Derangement {
    public static List<List<Integer>> findDerangement(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, res, new ArrayList<>());
        return res;
    }

    private static void dfs(int n, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (list.contains(i) || list.size()+1 == i) continue;
            list.add(i);
            dfs(n, res, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = findDerangement(3);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
}

