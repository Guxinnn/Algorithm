package Company.IXL;
import java.util.*;
/**
 * Created by Doodle on 2/3/18.
 */
public class MinStickers {
    public int minStickers(String[] stickers, String target) {
        if (target.length() == 0) return 0;

        int ns = stickers.length;
        int tl = target.length();

        int[][] letters = new int[ns][26];

        for (int i = 0; i < stickers.length; i++) {
            String s = stickers[i];
            for (char c : s.toCharArray()) {
                letters[i][c-'a']++;
            }
        }

        int[] targetLetters = new int[26];
        for (char c : target.toCharArray()) {
            targetLetters[c-'a']++;
        }

        // initialize bfs
        int level = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.offer(targetLetters);

        // bfs
        while (!q.isEmpty()) {
            level++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                String curKey = toKey(cur);

                // iterate all stickers
                if (set.add(curKey)) {
                    for (int j = 0; j < letters.length; j++) {
                        int[] curtarget = cur.clone();
                        for (int k = 0; k < 26; k++) {
                            int left = curtarget[k] - letters[j][k];
                            curtarget[k] = Math.max(0, left);
                        }

                        String tmp = toKey(curtarget);
                        if (tmp.length() == 0) return level;
                        q.offer(curtarget);
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
                sb.append((char)(arr[i]+'a'));
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
