package dsalgo.easy.grokking.mergeintervals.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dsalgo.common.Interval;

public class EmployeeFreeTime {

	// For ‘K’ employees, we are given a list of intervals representing the working
	// hours of each employee. Our goal is to find out if there is a free interval
	// that is common to all employees. You can assume that each list of employee
	// working hours is sorted on the start time.
	//
	// Example 1:
	//
	// Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
	// Output: [3,5]
	// Explanation: Both the employess are free between [3,5].
	// Example 2:
	//
	// Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
	// Output: [4,6], [8,9]
	// Explanation: All employess are free between [4,6] and [8,9].
	// Example 3:
	//
	// Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
	// Output: [5,7]
	// Explanation: All employess are free between [5,7].

	public static List<Interval> getEmployeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> result = new ArrayList<Interval>();

		List<Interval> intervals = schedule.stream().flatMap(List::stream).collect(Collectors.toList());
		intervals.sort((i1, i2) -> i1.start - i2.start);

		int i = 1;
		System.out.println(intervals);
		while (i < intervals.size()) {
			Interval start = intervals.get(i - 1);
			Interval end = intervals.get(i);
			if (start.end > end.start) {
				start.end = Math.max(start.end, end.end);
				intervals.remove(i);
			} else {
				if (end.start - start.end > 0) {
					result.add(new Interval(start.end, end.start));
				}
				i++;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		List<List<Interval>> schedules = new ArrayList<>();
		List<Interval> schedule1 = new ArrayList<Interval>();
		schedule1.add(new Interval(1, 3));
		schedule1.add(new Interval(5, 6));

		List<Interval> schedule2 = new ArrayList<Interval>();
		schedule2.add(new Interval(2, 3));
		schedule2.add(new Interval(6, 8));

		schedules.add(schedule1);
		schedules.add(schedule2);

		System.out.println(getEmployeeFreeTime(schedules));

		schedule1 = new ArrayList<Interval>();
		schedule1.add(new Interval(1, 3));

		schedule2 = new ArrayList<Interval>();
		schedule2.add(new Interval(2, 4));

		List<Interval> schedule3 = new ArrayList<Interval>();
		schedule3.add(new Interval(3, 5));
		schedule3.add(new Interval(7, 9));

		schedules.clear();
		
		schedules.add(schedule1);
		schedules.add(schedule2);
		schedules.add(schedule3);
		
		System.out.println(getEmployeeFreeTime(schedules));
		
		schedule1 = new ArrayList<Interval>();
		schedule1.add(new Interval(1, 3));
		schedule1.add(new Interval(9, 12));

		schedule2 = new ArrayList<Interval>();
		schedule2.add(new Interval(2, 4));
		schedule2.add(new Interval(6, 8));

		schedules.clear();
		
		schedules.add(schedule1);
		schedules.add(schedule2);
		
		System.out.println(getEmployeeFreeTime(schedules));
		
	}

}
