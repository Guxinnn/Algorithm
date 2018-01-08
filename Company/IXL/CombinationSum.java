package Company.IXL;

import java.util.*;
/**
 * Created by Doodle on 2/4/18.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        dfs(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int pos) {
        if (target == 0) res.add(new ArrayList<>(list));
        if (target < 0) return;

        for (int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(res, list, candidates, target - candidates[i], i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();

        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();
        res = c.combinationSum(candidates, target);

        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
}
