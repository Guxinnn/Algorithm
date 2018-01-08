package Backtracking;
import java.util.*;
/**
 * Created by Doodle on 9/13/17.
 */
public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        dfs(res, "", num, target, 0, 0, 0);
        return res;
    }

    private static void dfs(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if(pos == num.length()) {
            if(eval == target) {
                res.add(path);
            }
            return;
        }

        for(int i = pos; i < num.length(); i++) {
            if(i != pos && num.charAt(i) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i+1));

            if(pos == 0) {
                dfs(res, path+cur, num, target, i+1, cur, cur);
            } else {
                dfs(res, path + "+" + cur, num, target, i+1, eval+cur, cur);
                dfs(res, path + "-" + cur, num, target, i+1, eval-cur, -cur);
                dfs(res, path + "*" + cur, num, target, i+1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num, target));
    }

}
