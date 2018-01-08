package Heap;

import java.util.*;

/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>();
        pq.addAll(map.entrySet());

        int count = 0;
        while(!pq.isEmpty()) {
            int k = n+1;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();

            while(!pq.isEmpty() && k > 0) {
                Map.Entry<Character, Integer> cur = pq.poll();
                cur.setValue(cur.getValue()-1);
                list.add(cur);
                count++;
                k--;
            }

            for (Map.Entry<Character, Integer> e : list) {
                if(e.getValue() > 0) pq.offer(e);
            }

            if (pq.isEmpty()) break;
            count += k;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
