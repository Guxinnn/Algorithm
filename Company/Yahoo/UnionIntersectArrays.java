package Company.Yahoo;

import java.util.*;

/**
 * Created by Doodle on 2/13/18.
 */
public class UnionIntersectArrays {
    public List<Integer> unionSorted(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                res.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                res.add(arr2[j]);
                j++;
            } else {
                res.add(arr2[j]);
                i++;
                j++;
            }
        }

        while (i < len1) {
            res.add(arr1[i]);
            i++;
        }
        while (j < len2) {
            res.add(arr2[j]);
            j++;
        }

        return res;
    }

    public List<Integer> intersectSorted(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) i++;
            else if (arr1[i] > arr2[j]) j++;
            else {
                res.add(arr1[i]);
                i++;
                j++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        UnionIntersectArrays u = new UnionIntersectArrays();
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};

        System.out.println(u.intersectSorted(arr1, arr2));
    }
}
