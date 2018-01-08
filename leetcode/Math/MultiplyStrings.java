package Math;

/**
 * Created by Doodle on 9/11/17.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";

        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1+n2];

        for(int i = n1-1; i >= 0; i--) {
            for(int j = n2-1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i+j+1] += d1 * d2;
            }
        }

        int carry = 0;
        for(int i = products.length-1; i >= 0; i--) {
            int tmp = carry + products[i];
            carry = tmp / 10;
            products[i] = tmp % 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int number : products) {
            sb.append(number);
        }

        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        String res = multiply(s1, s2);
        System.out.println(res);
    }
}
