package Company.IXL;

import java.util.*;

public class Fibonacci {
    List<Integer> list;

    public Fibonacci() {
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
    }

    public int randomFibo(int bound) {

        while (bound > list.get(list.size()-1)) {
            int val = list.get(list.size()-1) + list.get(list.size()-2);
            list.add(val);
        }

        int size = list.size();
        Random rand = new Random();
        return list.get(rand.nextInt(size));
    }
}