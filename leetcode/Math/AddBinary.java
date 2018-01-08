package Math;

/**
 * Created by Doodle on 9/12/17.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry = 0;

        while(i >= 0 || j >= 0) {
            int sum =  carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "11", s2 = "1";
        String res = addBinary(s1, s2);
        System.out.println(res);
    }
}
