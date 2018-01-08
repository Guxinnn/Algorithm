package leetcode.Array;
import java.util.*;

public class FindDisappearNumber {
  public List<Integer> findDisappearedNumbers(int[] nums) {

      // [1,1,2,4]
      // [-1,-1, 2, -4]
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        res.add(i+1);
      }
    }

    return res;
  }
}
