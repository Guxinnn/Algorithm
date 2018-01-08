package Company.IXL;

import java.util.HashMap;

/**
 * Created by Doodle on 2/2/18.
 */
public class RepeatingDecimal {
    public String repeatingDecimal(int n) {
        long rem = 1;
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                return sb.substring(index, sb.length()).toString();
            } else {
                map.put(rem, sb.length());
                rem = rem * 10;
                sb.append(rem / n);
                rem = rem % n;
            }
        }

        return "0";
    }

}
