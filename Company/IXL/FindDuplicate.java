package Company.IXL;

/**
 * Created by Doodle on 2/2/18.
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;

        int slow = nums[0], fast = nums[nums[0]];

        while (slow != fast) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
