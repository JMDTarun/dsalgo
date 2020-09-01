package dsalgo.easy.algoexpert.veryhard;

import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPrattAlgorithm {

	public static int[] prefixFunction(String str) {
	    /* 1 */
	    int[] prefixFunc = new int[str.length()];

	    /* 2 */
	    for (int i = 1; i < str.length(); i++) {
	        /* 3 */
	        int j = prefixFunc[i - 1];

	        while (j > 0 && str.charAt(i) != str.charAt(j)) {
	            j = prefixFunc[j - 1];
	        }

	        /* 4 */
	        if (str.charAt(i) == str.charAt(j)) {
	            j += 1;
	        }

	        /* 5 */
	        prefixFunc[i] = j;
	    }

	    /* 6 */
	    return prefixFunc;
	}
	
	public static List<Integer> KMPSearch(String text, String pattern) {
	    /* 1 */
	    int[] prefixFunc = prefixFunction(pattern);
	    ArrayList<Integer> occurrences = new ArrayList<Integer>();
	    int j = 0;
	    /* 2 */
	    for (int i = 0; i < text.length(); i++) {
	        /* 3 */
	        while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
	            j = prefixFunc[j - 1];
	        }
	        /* 4 */
	        if (text.charAt(i) == pattern.charAt(j)) {
	            j += 1;
	        }
	        /* 5 */
	        if (j == pattern.length()) {
	            occurrences.add(i - j + 1);
	            j = prefixFunc[j - 1];
	        }
	    }
	   /* 6 */
	    return occurrences;
	}
	
	public static void main(String[] args) {
		List<Integer> occurrences = KMPSearch("ABACABAD", "ABA");
		System.out.println(occurrences); // [0, 4]

		List<Integer> occurrences1 = KMPSearch("ABABA", "ABA");
		System.out.println(occurrences1); // [0, 2]
	}

}
