package dsalgo.leetcode.hard;

public class LC_4_MedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sum = nums1.length + nums2.length;
		int num1 = 0;
		int num2 = 0;
		double result = 0;
		if (sum == 0) {
			return result;
		}
		int leftIndex = sum % 2 == 0 ? sum / 2 - 1 : sum / 2;
		int rightIndex = sum % 2 == 0 ? leftIndex + 1 : leftIndex;

		int index = 0;
		int index1 = 0, index2 = 0;
		int length = rightIndex + 1;
		for (int i = 0; i < length; i++) {
			if (index <= nums1.length && nums1[index1] < nums2[index2]) {
				index1++;
				if (index == leftIndex || index == rightIndex) {
					num1 = nums1[index1];
					if (leftIndex == rightIndex) {
						return num1;
					}
				}
				index++;
			} else if (index <= nums2.length && nums2[index2] < nums1[index1]) {
				index2++;
				if (index == leftIndex || index == rightIndex) {
					num2 = nums2[index2];
					if (leftIndex == rightIndex) {
						return num2;
					}
				}
				index++;
			}
		}
		result = (num1 + num2) / 2.0;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
	}

}
