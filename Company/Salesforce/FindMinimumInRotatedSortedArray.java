package Company.Salesforce;

/**
 * Created by Doodle on 3/7/18.
 */

// assume element in the array is unique.
// [1,2,3,4,5,6] -> [3,4,5,6,1,2]

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while (start < end) {
            if (nums[start] < nums[end]) return start;

            int mid = start + (end - start) / 2;

            if (nums[mid] >= nums[start]) {
                // rotation is in the second half
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}
