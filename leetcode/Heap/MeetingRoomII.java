package Heap;
import java.util.*;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */
class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
public class MeetingRoomII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));

        PriorityQueue<Interval> pq = new PriorityQueue<>();
        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = pq.poll();

            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }

            pq.offer(interval);
        }

        return pq.size();

    }
}
