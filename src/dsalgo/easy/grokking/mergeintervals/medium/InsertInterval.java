package dsalgo.easy.grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dsalgo.common.Interval;

public class InsertInterval {

	// Given a list of non-overlapping intervals sorted by their start time, insert
	// a given interval at the correct position and merge all necessary intervals to
	// produce a list that has only mutually exclusive intervals.
	//
	// Example 1:
	//
	// Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
	// Output: [[1,3], [4,7], [8,12]]
	// Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them
	// into one [4,7].
	// Example 2:
	//
	// Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
	// Output: [[1,3], [4,12]]
	// Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we
	// merged them into [4,12].
	// Example 3:
	//
	// Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
	// Output: [[1,4], [5,7]]
	// Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them
	// into one [1,4].

	public static List<Interval> insert(List<Interval> intervals, Interval interval) {
		for (int i = 0; i < intervals.size(); i++) {
			Interval start = intervals.get(i);
			Interval end = interval;
			if (start.start >= end.start) {
				intervals.add(i, interval);
				break;
			}
		}
		int i = 1;
		while (i < intervals.size()) {
			Interval start = intervals.get(i - 1);
			Interval end = intervals.get(i);
			if (start.start <= end.start && end.start <= start.end) {
				start.end = Math.max(start.end, end.end);
				intervals.remove(i);
			} else {
				i++;
			}
		}
		return intervals;
	}

	public static List<Interval> insertAndMergeInterval(List<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			} else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start),
						Math.max(newInterval.end, interval.end));
			}
		}
		result.add(newInterval);
		return result;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(8, 12));
		System.out.println(insert(intervals, new Interval(4, 10)));
	}

}
