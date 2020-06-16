package dsalgo.easy.grokking.twopointer.medium;

public class ComparingStringsContainingBackspaces {

	// Comparing Strings containing Backspaces (medium) #
	// Given two strings containing backspaces (identified by the character ‘#’),
	// check if the two strings are equal.
	//
	// Example 1:
	//
	// Input: str1="xy#z", str2="xzz#"
	// Output: true
	// Explanation: After applying backspaces the strings become "xz" and "xz"
	// respectively.
	// Example 2:
	//
	// Input: str1="xy#z", str2="xyz#"
	// Output: false
	// Explanation: After applying backspaces the strings become "xz" and "xy"
	// respectively.
	// Example 3:
	//
	// Input: str1="xp#", str2="xyz##"
	// Output: true
	// Explanation: After applying backspaces the strings become "x" and "x"
	// respectively.
	// In "xyz##", the first '#' removes the character 'z' and the second '#'
	// removes the character 'y'.
	// Example 4:
	//
	// Input: str1="xywrrmp", str2="xywrrmu#p"
	// Output: true
	// Explanation: After applying backspaces the strings become "xywrrmp" and
	// "xywrrmp" respectively.

	public static boolean compare(String str1, String str2) {
		int str1Pointer = str1.length() - 1;
		int str2Pointer = str2.length() - 1;
		int str1HashCount = 0;
		int str2HashCount = 0;
		while (str1Pointer >= 0 && str2Pointer >= 0) {
			while (str1.charAt(str1Pointer) == '#') {
				str1HashCount++;
				str1Pointer = str1Pointer - 1;
			}
			while (str2.charAt(str2Pointer) == '#') {
				str2HashCount++;
				str2Pointer = str2Pointer - 1;
			}

			str1Pointer = str1Pointer - str1HashCount;
			str2Pointer = str2Pointer - str2HashCount;
			if (str1.charAt(str1Pointer) != str2.charAt(str2Pointer)) {
				return false;
			} else {
				str1HashCount = 0;
				str2HashCount = 0;
				str1Pointer--;
				str2Pointer--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(compare("xy#z", "xzz#"));
		System.out.println(compare("xy#z", "xyz#"));
		System.out.println(compare("xp#", "xyz##"));
		System.out.println(compare("xywrrmp", "xywrrmu#p"));
	}

}
