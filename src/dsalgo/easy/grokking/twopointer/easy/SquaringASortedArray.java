package dsalgo.easy.grokking.twopointer.easy;

public class SquaringASortedArray {

	// Given a sorted array, create a new array containing squares of all the number
	// of the input array in the sorted order.
	//
	// Input: [-2, -1, 0, 2, 3]
	// Output: [0, 1, 4, 4, 9]
	//
	// Input: [-3, -1, 0, 1, 2]
	// Output: [0 1 1 4 9]

	private static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		int firstNonNegativeIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) {
				firstNonNegativeIndex = i;
				break;
			}
		}
		int j = 0;
		int startPointer = firstNonNegativeIndex - 1;
		int endPointer = firstNonNegativeIndex;

		while (endPointer < arr.length && startPointer > 0) {

			if (Math.abs(arr[startPointer]) < arr[endPointer]) {
				squares[j] = arr[startPointer] * arr[startPointer];
				startPointer--;
			} else {
				squares[j] = arr[endPointer] * arr[endPointer];
				endPointer++;
			}
			j++;
		}

		while (startPointer >= 0) {
			squares[j] = arr[startPointer] * arr[startPointer];
			j++;
			startPointer--;
		}

		while (endPointer < arr.length) {
			squares[j] = arr[endPointer] * arr[endPointer];
			j++;
			endPointer++;
		}

		return squares;
	}

	private static int[] makeSquareRoot(int[] arr) {
		int[] squares = new int[arr.length];
		int startPointer = 0;
		int endPointer = arr.length - 1;
		int j = arr.length - 1;
		while (startPointer < endPointer) {
			int startSquare = arr[startPointer] * arr[startPointer];
			int endSquare = arr[endPointer] * arr[endPointer];
			if (startSquare > endSquare) {
				squares[j] = startSquare;
				startPointer++;
			} else {
				squares[j] = endSquare;
				endPointer--;
			}
			j--;
		}
		return squares;
	}

	public static void main(String[] args) {
		int[] arr = { -6,-5,-4,-3,-2,-1,0,1,2 };
		int[] makeSquareRoot = makeSquareRoot(arr);
		for (Integer a : makeSquareRoot) {
			System.out.println(a);
		}
	}

}
