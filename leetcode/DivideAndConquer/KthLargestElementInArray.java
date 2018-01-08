package DivideAndConquer;

import java.util.PriorityQueue;

/**
 * Created by Doodle on 9/22/17.
 */
public class KthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.offer(i);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;

        while (true) {
            while (i < hi && less(a[++i], a[lo]));
            while (j > lo && less(a[lo], a[--j]));

            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        System.out.println(findKthLargest(a, 2));
    }



}
