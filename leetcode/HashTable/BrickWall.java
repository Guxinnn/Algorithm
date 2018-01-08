package HashTable;
import java.util.*;

public class BrickWall {
    public int leastBrick(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                length += list.get(i);

                if(i != list.size()-1) {
                    map.put(length, map.getOrDefault(length, 0) + 1);
                }
            }
        }

        int maxLenCount = 0;
        for (int len : map.keySet()) {
            maxLenCount = Math.max(maxLenCount, map.get(len));
        }

        return wall.size() - maxLenCount;
    }

    public static void main(String[] args) {

    }
}
