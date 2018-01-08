package Company.IXL;

/**
 * Created by Doodle on 2/3/18.
 */
public class SecondLargestInArray {
    public int secondLargest(int[] array) {
        if (array == null || array.length < 2) System.out.println("Invalid Input");

        int i, first, second;
        first = second = Integer.MIN_VALUE;

        for (i = 0; i < array.length; i++) {
            if (array[i] > first) {
                second = first;
                first = array[i];
            } else if (array[i] > second && array[i] != first) {
                second = array[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("no second largest element");
            return -1;
        }

        return second;
    }
}
