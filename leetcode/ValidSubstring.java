/**
 * Created by Doodle on 9/15/17.
 */
import java.util.*;

public class ValidSubstring {
    public static int validString(String s) {
        int N = s.length();

        int i = 0, j = 0, count = 0, start = 0, end = 0;
        boolean flag = false;

        while(j < N) {
            if(s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                if(flag && j-i > end - start) {
                    start = i;
                    end = j-1;
                }
                i = j+1;
            }
            if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                flag = true;
            }
            j++;
        }
        if(j-i+1 > end-start) {
            end = j-1;
            start = i;
        }

        return end+1-start;
    }

    public static void main(String[] args) {
        String s = "abZ01cBaz2caaaa";
        System.out.println(validString(s));
    }
}
