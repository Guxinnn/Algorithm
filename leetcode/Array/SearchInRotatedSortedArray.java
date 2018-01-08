package Array;

/**
 * Created by Doodle on 9/11/17.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length-1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) return mid;
            if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return nums[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int res = search(a, 2);
        System.out.println(res);
    }
}
