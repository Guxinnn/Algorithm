package leetcode.BinarySearch;

/**
 * Created by Doodle on 2/17/18.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;

        int start = 0, end = nums.length-1;

        // find left index
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // continue to search left
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        // check start and end
        if (nums[start] == target) {
            res[0] = start;
        } else if (nums[end] == target) {
            res[0] = end;
        }

        // find right index
        start = 0;
        end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // continue to search right
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid-1;
            }
        }

        if (nums[end] == target) {
            res[1] = end;
        } else if (nums[start] == target) {
            res[1] = start;
        }

        return res;
    }
}
