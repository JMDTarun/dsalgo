package dsalgo.easy.grokking.slidingwindow.hard;

public class LongestSubstringWithSameLettersAfterReplacement {

	// Given a string with lowercase letters only, if you are allowed to replace no
	// more than ‘k’ letters with any letter, find the length of the longest
	// substring having the same letters after replacement.

	// Input: String="aabccbb", k=2
	// Output: 5
	// Explanation: Replace the two 'c' with 'b' to have a longest repeating
	// substring "bbbbb".
	//
	// Input: String="abbcb", k=1
	// Output: 4
	// Explanation: Replace the 'c' with 'b' to have a longest repeating substring
	// "bbbb".
	//
	// Input: String="abccde", k=1
	// Output: 3
	// Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating
	// substring "ccc".

	public static int findLength(String str, int k) {
		return -1;
	}

	public static void main(String[] args) {
		findLength("aabccbb", 2);
	}

}
