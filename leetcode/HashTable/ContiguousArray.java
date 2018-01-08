package HashTable;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) sum++;
            else sum--;

            if(map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContiguousArray c = new ContiguousArray();
        int[] arr = {0, 1};
        System.out.print(c.findMaxLength(arr));
    }
}
