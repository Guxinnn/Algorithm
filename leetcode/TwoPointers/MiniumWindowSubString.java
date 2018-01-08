package TwoPointers;
import java.util.*;
/**
 * Created by Doodle on 9/16/17.
 */
public class MiniumWindowSubString {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0, minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                map.put(r, map.get(r)-1);
                if(map.get(r) >= 0) count++;
            }
            while(count == t.length()) {
                if (right - left + 1 <  minLen) {
                    minLeft = left;
                    minLen = right - left + 1;
                }
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) count--;
                }
                left++;
            }
        }

        return minLen == s.length()+1 ? "" : s.substring(minLeft, minLeft+minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
