package dsalgo.easy.algoexpert.hard;

public class UndersorifyString {

	public static String underscorifyString(String str, String word) {
		int j = 0;
		StringBuilder strBuilder = new StringBuilder();
		while (j < str.length()) {
			if (word.charAt(0) == str.charAt(j)) {
				boolean isAppendUnderscoreAtStart = isContineousOrNextWord(str, word, j);
				if (isAppendUnderscoreAtStart) {
					strBuilder.append("_");
					j += word.length() - 1;
					appCharactersToString(strBuilder, str, word, 0);
					
					boolean isContigeous = isContineousOrNextWord(str, word, j);
					boolean isNext = isContineousOrNextWord(str, word, j + 1);
					while (isContigeous || isNext) {
						j += isContigeous ? word.length() - 1 : word.length();
						appCharactersToString(strBuilder, str, word, isContigeous ? 1 : 0);
						isContigeous = isContineousOrNextWord(str, word, j);
						isNext = isContineousOrNextWord(str, word, j + 1);
					}
					strBuilder.append("_");

				} else {
					strBuilder.append(str.charAt(j));
				}
				j++;
			} else {
				strBuilder.append(str.charAt(j));
				j++;
			}
		}
		return strBuilder.toString();
	}

	private static void appCharactersToString(StringBuilder strBuilder, String str, String word, int startCharIndex) {
		for (int k = startCharIndex; k < word.length(); k++) {
			strBuilder.append(str.charAt(k));
		}
	}

	private static boolean isContineousOrNextWord(String str, String word, int j) {
		for (int k = 0; k < word.length(); k++) {
			if (str.charAt(j++) != word.charAt(k)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "testthis is a testtest to see if testesttestt it works";
		System.out.println(underscorifyString(str, "test"));

	}

}
