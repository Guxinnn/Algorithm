package Company.VMWare;

import java.util.*;
/**
 * Created by Doodle on 2/18/18.
 */
public class PascalTriangle {
    // I
    public List<List<Integer>> generate(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        if (rowIndex < 0) return res;

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) list.add(1);
                else {
                    list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }

            res.add(list);
        }

        return res;
    }

    // II
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j+1));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(4));
    }
}
