package dsalgo.easy.grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.Interval;

public class IntervalIntersactions {

	// Problem Statement #
	// Given two lists of intervals, find the intersection of these two lists. Each
	// list consists of disjoint intervals sorted on their start time.
	//
	// Example 1:
	//
	// Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
	// Output: [2, 3], [5, 6], [7, 7]
	// Explanation: The output list contains the common intervals between the two
	// lists.
	// Example 2:
	//
	// Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
	// Output: [5, 7], [9, 10]
	// Explanation: The output list contains the common intervals between the two
	// lists.

	public static Interval[] merge(List<Interval> arr1, List<Interval> arr2) {
		List<Interval> mergedIntervals = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < arr1.size() && j < arr2.size()) {
			Interval start = arr1.get(i);
			Interval end = arr2.get(j);
			if (start.start < end.start) {
				mergedIntervals.add(start);
				i++;
			} else if (start.start > end.start) {
				mergedIntervals.add(end);
				j++;
			} else {
				if (start.end > end.end) {
					mergedIntervals.add(end);
					j++;
				} else {
					mergedIntervals.add(start);
					i++;
				}
			}
		}
		while (i < arr1.size()) {
			mergedIntervals.add(arr1.get(i++));
		}
		while (j < arr2.size()) {
			mergedIntervals.add(arr2.get(++j));
		}

		int k = 1;
		List<Interval> intersactions = new ArrayList<>();
		while (k < mergedIntervals.size()) {
			Interval start = mergedIntervals.get(k - 1);
			Interval end = mergedIntervals.get(k);
			if (start.start <= end.start && end.start <= start.end) {
				intersactions.add(new Interval(Math.max(start.start, end.start), Math.min(start.end, end.end)));
			}
			k++;
		}
		System.out.println(intersactions);
		return intersactions.toArray(new Interval[intersactions.size()]);
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(9, 12));

		List<Interval> intervals1 = new ArrayList<>();
		intervals1.add(new Interval(5, 10));
		// intervals1.add(new Interval(5, 7));

		merge(intervals, intervals1);
	}

}
