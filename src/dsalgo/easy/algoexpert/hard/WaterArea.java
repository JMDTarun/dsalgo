package dsalgo.easy.algoexpert.hard;

import java.util.Arrays;

public class WaterArea {

	public static int maximumWater(int[] arr) {

		int[] cache = new int[arr.length];

		int max = arr[0];
		int sum = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] < max) {
				cache[i] = max - arr[i];
			} else {
				max = arr[i];
			}
		}
		int min = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < min) {
				cache[i] = Math.min(cache[i], min - arr[i]);
			} else {
				cache[i] = 0;
				min = arr[i];
			}
			sum += cache[i];
		}
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(maximumWater(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(maximumWater(new int[] { 2, 0, 2 }));
		System.out.println(maximumWater(new int[] { 3, 0, 2, 0, 4 }));

		System.out.println(maximumWater(new int[] { 3, 0, 1, 2, 3 }));
		System.out.println(maximumWater(new int[] { 3, 0, 1, 2, 3, 0, 5 }));
		System.out.println(maximumWater(new int[] { 3, 0, 1, 3, 0, 5 }));
		System.out.println(maximumWater(new int[] { 3, 0, 5, 3, 0, 1 }));

	}

}
