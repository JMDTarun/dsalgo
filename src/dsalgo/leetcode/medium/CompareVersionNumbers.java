package dsalgo.leetcode.medium;

public class CompareVersionNumbers {

	public static int compareVersion(String version1, String version2) {
		int v1Length = version1.length();
		int v2Length = version2.length();

		int v1Start = 0;
		int v2Start = 0;

		while (v1Start < v1Length || v2Start < v2Length) {
			int v1Temp = 0;
			int v2Temp = 0;
			while (v1Start < v1Length && version1.charAt(v1Start) != '.') {
				v1Temp = v1Temp * 10 + Character.getNumericValue(version1.charAt(v1Start));
				v1Start++;
			}

			while (v2Start < v2Length && version2.charAt(v2Start) != '.') {
				v2Temp = v2Temp * 10 + Character.getNumericValue(version2.charAt(v2Start));
				v2Start++;
			}

			if (v1Temp < v2Temp) {
				return -1;
			} else if (v1Temp > v2Temp) {
				return 1;
			} else {
				v1Start++;
				v2Start++;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("1.0.1", "1"));
	}

}
