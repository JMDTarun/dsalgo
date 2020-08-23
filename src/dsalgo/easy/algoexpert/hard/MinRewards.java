package dsalgo.easy.algoexpert.hard;

import java.util.Arrays;

public class MinRewards {

	// There are N children standing in a line. Each child is assigned a rating
	// value.
	//
	// You are giving candies to these children subjected to the following
	// requirements:
	//
	// 1. Each child must have at least one candy.
	// 2. Children with a higher rating get more candies than their neighbors.
	// What is the minimum candies you must give?
	//
	// Input Format:
	//
	// The first and the only argument contains N integers in an array A.
	// Output Format:
	//
	// Return an integer, representing the minimum candies to be given.
	// Example:
	//
	// Input 1:
	// A = [1, 2]
	//
	// Output 1:
	// 3
	//
	// Explanation 1:
	// The candidate with 1 rating gets 1 candy and candidate with rating cannot get
	// 1 candy as 1 is its neighbor.
	// So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be
	// given out.
	//
	// Input 2:
	// A = [1, 5, 2, 1]
	//
	// Output 2:
	// 7
	//
	// Explanation 2:
	// Candies given = [1, 3, 2, 1]

	public static int minimumCandies(int[] ratings) {
		int[] candies = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			candies[i] = 1;
		}

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 1; i >= 1; i--) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i] + 1;
			}
		}
		return Arrays.stream(candies).sum();
	}

	public static void main(String[] args) {
		System.out.println(minimumCandies(new int[] { 1, 5, 2, 1 }));
		System.out.println(minimumCandies(new int[] { 1, 2 }));
		System.out.println(minimumCandies(new int[] { 1, 0, 2 }));
		System.out.println(minimumCandies(new int[] { 1, 2, 2 }));
		System.out.println(minimumCandies(new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 }));
		System.out.println(minimumCandies(new int[] { 4, 6, 4, 5, 6, 2 }));
	}

}
