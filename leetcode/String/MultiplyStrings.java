package String;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
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

        int index = 0;
        for(int i = 0; i < products.length; i++) {
            if(products[i] != 0) {
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = index; i < products.length; i++) {
            sb.append(i);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";

        System.out.println(m.multiply(num1, num2));
    }
}
