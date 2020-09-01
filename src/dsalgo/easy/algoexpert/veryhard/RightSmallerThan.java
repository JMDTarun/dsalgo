package dsalgo.easy.algoexpert.veryhard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dsalgo.common.TreeNode;

public class RightSmallerThan {

	// You are given an integer array nums and you have to return a new counts
	// array. The counts array has the property where counts[i] is the number of
	// smaller elements to the right of nums[i].
	//
	//
	//
	// Example 1:
	//
	// Input: nums = [5,2,6,1]
	// Output: [2,1,1,0]
	// Explanation:
	// To the right of 5 there are 2 smaller elements (2 and 1).
	// To the right of 2 there is only 1 smaller element (1).
	// To the right of 6 there is 1 smaller element (1).
	// To the right of 1 there is 0 smaller element.

	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		res.add(0);
		for (int i = nums.length - 2; i >= 0; i--) {
			int count = insertNode(root, nums[i]);
			res.add(count);
		}
		root.print(root);
		Collections.reverse(res);
		return res;
	}

	public static int insertNode(TreeNode root, int val) {
		int thisCount = 0;
		while (true) {
			if (val <= root.val) {
				root.count++;
				if (root.left == null) {
					root.left = new TreeNode(val);
					break;
				} else {
					root = root.left;
				}
			} else {
				thisCount += root.count;
				if (root.right == null) {
					root.right = new TreeNode(val);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return thisCount;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 8, 5, 11, -1, 3, 4, 2 };
		System.out.println(countSmaller(nums));
	}

}
