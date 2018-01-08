package Heap;
import LinkedList.ListNode;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Created by Doodle on 9/11/17.
 */
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        // return sort(lists, 0, lists.length-1);

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if(l1.val < l2.val) {
                    return -1;
                } else if(l1.val == l2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }

        while(!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if(tail.next != null) {
                pq.add(tail.next);
            }
        }

        return dummy.next;
    }

}
