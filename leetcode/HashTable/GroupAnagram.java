package HashTable;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 */

import java.security.acl.Group;
import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] sarray = s.toCharArray();
            Arrays.sort(sarray);
            String keyStr = new String(sarray);

            if (map.containsKey(keyStr)) {
                map.get(keyStr).add(s);
            } else {
                map.put(keyStr, new ArrayList<>());
                map.get(keyStr).add(s);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }

        return res;
    }

    public static void main(String[] args) {
        GroupAnagram g = new GroupAnagram();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(str));
    }
}
