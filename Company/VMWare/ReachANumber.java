package Company.VMWare;

import java.util.*;

/**
 * Created by Doodle on 2/17/18.
 */
public class ReachANumber {
    public int reachNumber(int target) {
        if (target == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int round = 1;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                int forward = pos + round;
                int backward = pos - round;

                if (forward == target || backward == target) {
                    return round;
                }

                System.out.println("forward : " + forward);
                System.out.println("backward : " + backward);
                queue.offer(forward);
                queue.offer(backward);
            }

            round += 1;
        }

        return round;
    }

    public static void main(String[] args) {
        ReachANumber r = new ReachANumber();

        System.out.println(r.reachNumber(3));
//        r.reachNumber(3);
    }

}
