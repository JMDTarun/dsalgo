package dsalgo.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public int val;
	public String strVal;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	public int count = 1;

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(String val) {
		this.strVal = val;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", strVal=" + strVal + ", left=" + left + ", right=" + right + ", next=" + next
				+ "]";
	}

	public void printLevelOrder() {
		TreeNode nextLevelRoot = this;
		while (nextLevelRoot != null) {
			TreeNode current = nextLevelRoot;
			nextLevelRoot = null;
			while (current != null) {
				System.out.print(current.val + " ");
				if (nextLevelRoot == null) {
					if (current.left != null) {
						nextLevelRoot = current.left;
					} else if (current.right != null) {
						nextLevelRoot = current.right;
					}
				}
				current = current.next;
			}
			System.out.println();
		}
	}

	public void print(TreeNode root) {
		List<List<String>> lines = new ArrayList<List<String>>();

		List<TreeNode> level = new ArrayList<TreeNode>();
		List<TreeNode> next = new ArrayList<TreeNode>();

		level.add(root);
		int nn = 1;

		int widest = 0;

		while (nn != 0) {
			List<String> line = new ArrayList<String>();

			nn = 0;

			for (TreeNode n : level) {
				if (n == null) {
					line.add(null);

					next.add(null);
					next.add(null);
				} else {
					String aa = String.valueOf(n.val);
					line.add(aa);
					if (aa.length() > widest)
						widest = aa.length();

					next.add(n.left);
					next.add(n.right);

					if (n.left != null)
						nn++;
					if (n.right != null)
						nn++;
				}
			}

			if (widest % 2 == 1)
				widest++;

			lines.add(line);

			List<TreeNode> tmp = level;
			level = next;
			next = tmp;
			next.clear();
		}

		int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
		for (int i = 0; i < lines.size(); i++) {
			List<String> line = lines.get(i);
			int hpw = (int) Math.floor(perpiece / 2f) - 1;

			if (i > 0) {
				for (int j = 0; j < line.size(); j++) {

					// split node
					char c = ' ';
					if (j % 2 == 1) {
						if (line.get(j - 1) != null) {
							c = (line.get(j) != null) ? '┴' : '┘';
						} else {
							if (j < line.size() && line.get(j) != null)
								c = '└';
						}
					}
					System.out.print(c);

					// lines and spaces
					if (line.get(j) == null) {
						for (int k = 0; k < perpiece - 1; k++) {
							System.out.print(" ");
						}
					} else {

						for (int k = 0; k < hpw; k++) {
							System.out.print(j % 2 == 0 ? " " : "─");
						}
						System.out.print(j % 2 == 0 ? "┌" : "┐");
						for (int k = 0; k < hpw; k++) {
							System.out.print(j % 2 == 0 ? "─" : " ");
						}
					}
				}
				System.out.println();
			}

			// print line of numbers
			for (int j = 0; j < line.size(); j++) {

				String f = line.get(j);
				if (f == null)
					f = "";
				int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
				int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

				// a number
				for (int k = 0; k < gap1; k++) {
					System.out.print(" ");
				}
				System.out.print(f);
				for (int k = 0; k < gap2; k++) {
					System.out.print(" ");
				}
			}
			System.out.println("\n\n\n\n");

			perpiece /= 2;
		}
	}
}
