package dsalgo.practice;

public class GenerateAllBinaryWithoutConsecutive1s {

	public static void main(String[] args) {
		printConsecutive("");
	}

	private static void printConsecutive(String str) {
		if (str.length() == 3) {
			System.out.println(str);
			return;
		}
		printConsecutive(str.concat("0"));
		if (str.length() == 0 || (str.charAt(str.length() - 1) != '1')) {
			printConsecutive(str.concat("1"));
		}
	}
}
