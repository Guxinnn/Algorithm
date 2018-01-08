package HashTable;
import java.util.*;
public class MaximumSizeSubArraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <sum, index> pairs

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = i+1;

            if (map.containsKey(sum - k)) {
                max = Math.max(max, i-map.get(sum-k));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSizeSubArraySumEqualsK m = new MaximumSizeSubArraySumEqualsK();
        int[] t = {1, -1, 5, -2, 3};
        System.out.println(m.maxSubArrayLen(t, 3));
    }
}
