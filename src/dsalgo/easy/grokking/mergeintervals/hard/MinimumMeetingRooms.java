package dsalgo.easy.grokking.mergeintervals.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import dsalgo.common.Interval;

public class MinimumMeetingRooms {

	public static int findMinimumMeetingRooms(List<Interval> meetings) {
		int minimumMeetingRooms = 0;
		Collections.sort(meetings, (m1, m2) -> m1.start - m2.start);
		PriorityQueue<Interval> minHeap = new PriorityQueue<>((m1, m2) -> m1.end - m2.end);
		for (Interval meeting : meetings) {
			while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
				minHeap.poll();
			}
			minHeap.offer(meeting);
			minimumMeetingRooms = Math.max(minimumMeetingRooms, minHeap.size());
		}
		return minimumMeetingRooms;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(4, 5));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(3, 5));
		findMinimumMeetingRooms(intervals);
	}

}
