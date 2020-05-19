package dsalgo.easy.grokking.mergeintervals.medium;

import java.util.ArrayList;
import java.util.List;

import dsalgo.common.Interval;

public class ConflictingAppointments {

	public static boolean canAttendAllAppointments(List<Interval> intervals) {
		intervals.sort((i1, i2) -> i1.start - i2.start);
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= intervals.get(i - 1).end) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(8, 12));
		System.out.println(canAttendAllAppointments(intervals));
	}

}
