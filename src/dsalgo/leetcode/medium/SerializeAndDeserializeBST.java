package dsalgo.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dsalgo.common.TreeNode;

public class SerializeAndDeserializeBST {

	public String serialize(TreeNode root) {
		StringBuilder strBuilder = new StringBuilder();
		serializeTreeTemp(root, strBuilder);
		return strBuilder.substring(0, strBuilder.length() - 1);
	}

	private void serializeTreeTemp(TreeNode root, StringBuilder strBuilder) {
		if (root == null) {
			strBuilder.append("x,");
			return;
		}
		strBuilder.append(root.val).append(",");
		serializeTreeTemp(root.left, strBuilder);
		serializeTreeTemp(root.right, strBuilder);
	}

	public TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));
		TreeNode deserializeTemp = deserializeTemp(queue);
		return deserializeTemp;
	}

	public TreeNode deserializeTemp(Queue<String> queue) {
		if (!queue.isEmpty()) {
			String poll = queue.poll();
			if (poll.equals("x")) {
				return null;
			}
			TreeNode tempNode = new TreeNode(Integer.parseInt(poll));
			tempNode.left = deserializeTemp(queue);
			tempNode.right = deserializeTemp(queue);
			return tempNode;
		}
		return null;
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBST sbt = new SerializeAndDeserializeBST();
		TreeNode treeNode = new TreeNode(0);
		treeNode.left = new TreeNode(1);
		treeNode.right = new TreeNode(2);
		treeNode.right.left = new TreeNode(3);
		treeNode.right.right = new TreeNode(4);
		String serialize = sbt.serialize(treeNode);
		System.out.println(serialize);
		TreeNode deserialize = sbt.deserialize(serialize);
		System.out.println("Done");
	}

}
