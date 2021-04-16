package dsalgo.easy.grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dsalgo.common.Interval;

public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		intervals.sort((i1, i2) -> i1.start - i2.start);
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

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1])
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(3, 5));
		System.out.println(merge(intervals));
		
		int[][] intvals = {{1,3},{2,6},{8,10},{15,18}};
		merge(intvals);
		

	}

}
