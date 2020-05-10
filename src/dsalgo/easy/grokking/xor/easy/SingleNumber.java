package dsalgo.easy.grokking.xor.easy;

public class SingleNumber {

	public static int findSingleNumber(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = num;
			num = num ^ arr[i];
			System.out.println(temp + " ^ " + arr[i] + " = " + num);
		}
		return num;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 1, 3, 2, 3 };
		findSingleNumber(arr);
	}

}
