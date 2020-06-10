package dsalgo.easy.grokking.twoheaps.hard;

import java.util.PriorityQueue;

import dsalgo.common.Interval;

public class NextInterval {

	public static int[] findNextInterval(Interval[] intervals) {
		int[] result = new int[intervals.length];
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>((i1, i2) -> i1.index - i2.index);
		PriorityQueue<Interval> maxHeap = new PriorityQueue<Interval>((i1, i2) -> i1.index - i2.index);
		Interval firstInterval = intervals[0];
		minHeap.add(new Interval(firstInterval.start, firstInterval.end, 0));
		Interval secondInterval = intervals[1];
		maxHeap.add(new Interval(secondInterval.start, secondInterval.end, 1));
		int index = 2;
		int counter = 0;
		while (!maxHeap.isEmpty()) {
			Interval interval = maxHeap.peek();

			Interval peek = minHeap.peek();

			if (peek.end <= interval.start) {
				if (index < intervals.length) {
					Interval i = intervals[index];
					maxHeap.add(new Interval(i.start, i.end, index));
				}
				result[counter] = interval.index;
				counter++;
				minHeap.poll();
			} else {
				if (index < intervals.length) {
					Interval i = intervals[index];
					maxHeap.add(new Interval(i.start, i.end, index));
				}
			}
			if (minHeap.isEmpty() && maxHeap.size() > 0) {
				minHeap.add(maxHeap.poll());
			}
			if (index == intervals.length - 1) {
				minHeap.poll();
				minHeap.add(maxHeap.poll());
				result[counter] = -1;
				counter++;
			} else if (index > intervals.length) {
				minHeap.poll();
				minHeap.add(maxHeap.poll());
			}
			index++;
		}
		while (counter < intervals.length) {
			result[counter] = -1;
			counter++;
		}

		return result;
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
		// findNextInterval(intervals);
		// intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new
		// Interval(4, 6) };
		// findNextInterval(intervals);
		intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(10, 15), new Interval(6, 8),
				new Interval(8, 10), new Interval(5, 6) };
		findNextInterval(intervals);
	}

}
