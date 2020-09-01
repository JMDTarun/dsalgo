package dsalgo.easy.algoexpert.veryhard;

import java.util.Stack;

import dsalgo.common.TreeNode;

public class IterativeInOrderTraversal {

	public static void iterativeInOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root != null) {
			stack.push(root);
		}

		while (!stack.isEmpty()) {
			if (root != null) {
				if (root.left != null) {
					stack.push(root.left);
					root = root.left;
				} else if (root.right != null) {
					stack.push(root.right);
					root = root.right;
				} else {
					TreeNode pop = stack.pop();
					System.out.println(pop.val);
					root = null;
				}
			} else if (root == null) {
				TreeNode popValue = stack.pop();
				if (popValue.left == null && popValue.right == null) {
					System.out.println(popValue.val);
				} else if (popValue.right != null) {
					System.out.println(popValue.val);
					stack.push(popValue.right);
					root = popValue.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		iterativeInOrderTraversal(treeNode);
	}

}
