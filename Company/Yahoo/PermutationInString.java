package Company.Yahoo;

/**
 * Created by Doodle on 2/11/18.
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        if (len1 > len2) return false;
        int[] count = new int[26];

        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            if (i - len1 >= 0) count[s2.charAt(i - len1) - 'a']++;

            if (AllZero(count)) return true;
        }

        return false;
    }

    private boolean AllZero(int[] arr) {
        for (int i = 0; i <  arr.length; i++) {
            if (arr[i] != 0) return false;
        }

        return true;
    }
}
