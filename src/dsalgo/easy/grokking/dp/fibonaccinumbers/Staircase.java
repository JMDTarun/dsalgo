package dsalgo.easy.grokking.dp.fibonaccinumbers;

public class Staircase {

	public static int countWaysToClimb(int stairs) {
		if (stairs == 0) {
			return 1;
		}
		if (stairs < 0) {
			return 0;
		}
		return countWaysToClimb(stairs - 1) + countWaysToClimb(stairs - 2);
	}

	public static int countWaysToClimbTopDown(int stairs) {
		int[] matrix = new int[stairs + 1];
		matrix[0] = 1;
		for (int i = 1; i <= stairs; i++) {
			matrix[i] = matrix[i - 1] + (i - 2 >= 0 ? matrix[i - 2] : 0);
		}
		return matrix[stairs];
	}

	public static void main(String[] args) {
		System.out.println(countWaysToClimb(4));
		System.out.println(countWaysToClimbTopDown(4));
	}

}
