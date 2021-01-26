package dsalgo.practice;

public class AddictiveNumber {

	public static void main(String[] args) {
		System.out.println(isAddivtiveNumber("199100199", 0, 1, 2));
	}

	private static boolean isAddivtiveNumber(String str, int n1Start, int n1End, int n2End) {
		if (n2End > str.length() || str.equalsIgnoreCase("")) {
			return false;
		}

		String n1 = str.substring(n1Start, n1End);
		String n2 = str.substring(n1End, n2End);
		Integer i1 = Integer.parseInt(n1);
		Integer i2 = Integer.parseInt(n2);
		String sum = String.valueOf(i1 + i2);

		if (n2End + sum.length() > str.length()) {
			return false;
		}

		if (sum.equals(str.substring(n2End, n2End + sum.length()))) {
			System.out.println("Found Addictive");
			n1Start = n1End;
			n1End = n2End;
			n2End = n2End + sum.length();
			if (n2End + sum.length() > str.length()) {
				return true;
			}
			return isAddivtiveNumber(str, n1Start, n1End, n2End);
		}
		boolean isAddictiveNumber = false;
		for (int i = n1Start; i < str.length() / 2; i++) {
			boolean isAddictive = isAddivtiveNumber(str, n1Start, n1End, n2End + 1)
					|| isAddivtiveNumber(str, n1Start, n1End + 1, n2End);
			if (isAddictive) {
				isAddictiveNumber = true;
				break;
			}
		}
		return isAddictiveNumber;
	}
}
