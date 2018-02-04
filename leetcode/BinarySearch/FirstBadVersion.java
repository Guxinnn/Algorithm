package leetcode.BinarySearch;

// standard binary search
// boundary check: start + 1 < end
// return statement: check start first, and then end
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 0, end = n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                // go left
                end = mid;
            } else {
                // go right
                start = mid+1;
            }
        }

        return isBadVersion(start) ? start : end;
    }


    // deal with compile error
    private boolean isBadVersion(int version) {
        return true;
    }
}
