package dsalgo.easy.grokking.modifiedbinarysearch.medium;

public class CeilingOfANumber {

	public static int searchCeilingOfANumber(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		int index = -1;
		if (key > arr[right]) {
			return -1;
		} else if (key < arr[left]) {
			return left;
		}
		while (left <= right) {
			index = (left + right) / 2;
			if (arr[index] == key) {
				return index;
			}
			if (key < arr[index]) {
				right = index - 1;
			} else {
				left = index + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 8, 10, 15, 18, 20, 25, 26, 28, 30 };
		System.out.println(searchCeilingOfANumber(arr, 27));
	}

}
