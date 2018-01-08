package TwoPointers;
import Tree.TreeNode;

import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length  <= 2) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; //skip duplicate
            int a = nums[i];
            int start = i+1, end = nums.length-1;

            while(start < end) {
                if(a + nums[start] + nums[end] == 0) {
                    res.add(Arrays.asList(a, nums[start], nums[end]));
                    while(start < end && nums[start+1] == nums[start]) start++;
                    while(start < end && nums[end-1] == nums[end]) end--;
                    start++;
                    end--;
                } else if(a + nums[start] + nums[end] > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();

        int[] s = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = t.threeSum(s);
        System.out.println(list);
    }

}
