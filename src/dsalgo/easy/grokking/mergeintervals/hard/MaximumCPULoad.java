package dsalgo.easy.grokking.mergeintervals.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import dsalgo.common.Job;

public class MaximumCPULoad {

//	We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
//
//	Example 1:
//
//	Jobs: [[1,4,3], [2,5,4], [7,9,6]]
//	Output: 7
//	Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the 
//	jobs are running at the same time i.e., during the time interval (2,4).
//	Example 2:
//
//	Jobs: [[6,7,10], [2,4,11], [8,12,15]]
//	Output: 15
//	Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
//	Example 3:
//
//	Jobs: [[1,4,2], [2,4,1], [3,6,5]]
//	Output: 8
//	Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4]. 

	public static int findMaxCpuLoad(List<Job> jobs) {
		jobs.sort((j1, j2) -> j1.start - j2.start);
		PriorityQueue<Job> minHeap = new PriorityQueue<Job>((j1, j2) -> j1.end - j2.end);
		minHeap.add(jobs.get(0));
		int maxSoFar = jobs.get(0).cpuLoad;
		for (int i = 1; i < jobs.size(); i++) {
			Job job = minHeap.poll();
			if (job.end > jobs.get(i).start) {
				Job newJob = new Job(Math.min(job.start, jobs.get(i).start), Math.max(job.end, jobs.get(i).end),
						job.cpuLoad + jobs.get(i).cpuLoad);
				minHeap.add(newJob);
				maxSoFar = Math.max(maxSoFar, newJob.cpuLoad);
			} else {
				minHeap.add(jobs.get(i));
				maxSoFar = Math.max(maxSoFar, jobs.get(i).cpuLoad);
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job(1, 4, 3));
		jobs.add(new Job(2, 5, 4));
		jobs.add(new Job(7, 9, 6));
		System.out.println(findMaxCpuLoad(jobs));

		jobs = new ArrayList<Job>();
		jobs.add(new Job(6, 7, 10));
		jobs.add(new Job(2, 4, 11));
		jobs.add(new Job(8, 12, 15));
		System.out.println(findMaxCpuLoad(jobs));

		jobs = new ArrayList<Job>();
		jobs.add(new Job(1, 4, 2));
		jobs.add(new Job(2, 4, 1));
		jobs.add(new Job(3, 6, 5));
		System.out.println(findMaxCpuLoad(jobs));
	}

}
