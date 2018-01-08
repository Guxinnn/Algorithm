package BinarySearch;

/**
 * Created by Doodle on 9/21/17.
 */
public class Sqrt {
    public static int mySqrt(int x) {
        if(x == 0) return 0;

        int left = 1,  right = x;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

}
