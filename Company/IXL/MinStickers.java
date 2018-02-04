package Company.IXL;
import java.util.*;
/**
 * Created by Doodle on 2/3/18.
 */
public class MinStickers {
    public int minStickers(String[] stickers, String target) {
        // lower case
        if (target.length() == 0) return 0;
        int ns = stickers.length;
        int tl = target.length();
        int[][] letters = new int[ns][26];
        for (int i = 0; i < stickers.length; i++) {
            String s = stickers[i];
            for (char c : s.toCharArray()) {
                letters[i][c - 'a']++;
            }
        }

        int[] targetLetters = new int[26];
        for (char c : target.toCharArray()) {
            targetLetters[c - 'a']++;
        }

        int level = 0;
        Deque<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(); // visited
        queue.offerFirst(targetLetters);

        // bfs, starting from target
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pollLast();
                String curKey = toKey(cur);
                if (set.add(curKey)) {
                    for (int j = 0; j < letters.length; j++) {
                        // if (letters[j][curKey.charAt(0) - 'a'] == 0) continue;
                        int[] curtarget = cur.clone();
                        for (int k = 0; k < 26; k++) {
                            int left = curtarget[k] - letters[j][k];
                            curtarget[k] =  Math.max(left, 0);
                        }
                        String temp = toKey(curtarget);
                        if (temp.length() == 0) return level;
                        queue.offerFirst(curtarget);
                    }
                }
            }
        }
        return -1;
    }

    public String toKey(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append((char)(i+'a'));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MinStickers m = new MinStickers();

        String[] stickers = new String[]{"notice", "possible"};
        String target = "basicbasic";

        System.out.println(m.minStickers(stickers, target));
    }

}
