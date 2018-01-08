/**
 * Created by Doodle on 9/15/17.
 */
import java.util.*;
public class ElevStop {
    public static int elevStop(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        if(A == null || A.length == 0 || B == null || B.length == 0) return 0;

        Set<Integer> destFloors = new HashSet<>();
        int sumWeight = 0, numStop = 0, numInEle = 0;
        int index = 0;
        while(index < A.length) {

            while(sumWeight < Y && numInEle < X && index < A.length) {
                sumWeight += A[index];
                destFloors.add(B[index]);
                index ++;
                numInEle++;
            }

            numStop += destFloors.size() + 1;
            destFloors = new HashSet<>();
            numInEle = 0;
        }

        return numStop;
    }

    public static void main(String[] args) {
        int[] A = {40, 40, 100, 80, 20};
        int[] B = {3,3,2,2,3};

        System.out.println(elevStop(A, B, 3, 5, 200));
    }
}
