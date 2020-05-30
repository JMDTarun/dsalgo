package dsalgo.common;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;

	public TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
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

}
