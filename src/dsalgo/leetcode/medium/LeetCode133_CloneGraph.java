package dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode133_CloneGraph {
	public static Node cloneGraph(Node node) {
		Map<Node, Node> map = new HashMap<Node, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);

		Node clonedNode = new Node();
		clonedNode.val = node.val;
		clonedNode.neighbors = new ArrayList<Node>();
		
		map.put(node, clonedNode);

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			if (!map.containsKey(poll)) {
				clonedNode = new Node();
				clonedNode.val = poll.val;
				clonedNode.neighbors = new ArrayList<Node>();
				map.put(poll, clonedNode);
			}
			List<Node> neighbors = poll.neighbors;
			for (Node n : neighbors) {
				boolean isNeighbourToBeAdded = true;
				for (Node cn : map.get(poll).neighbors) {
					if (n.val == cn.val) {
						isNeighbourToBeAdded = false;
						break;
					}
				}
				if (isNeighbourToBeAdded) {
					Node clonedNeighbour = new Node();
					clonedNeighbour.val = n.val;
					clonedNeighbour.neighbors = new ArrayList<Node>();
					clonedNode.neighbors.add(clonedNeighbour);
					queue.add(n);
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		Node n1 = new Node();
		n1.val = 1;
		n1.neighbors = new ArrayList<Node>();
		Node n2 = new Node();
		n2.val = 2;
		n2.neighbors = new ArrayList<Node>();
		Node n3 = new Node();
		n3.val = 3;
		n3.neighbors = new ArrayList<Node>();
		Node n4 = new Node();
		n4.val = 4;
		n4.neighbors = new ArrayList<Node>();

		n1.neighbors.add(n2);
		n1.neighbors.add(n4);

		n2.neighbors.add(n1);
		n2.neighbors.add(n3);

		n3.neighbors.add(n2);
		n3.neighbors.add(n4);

		n4.neighbors.add(n1);
		n4.neighbors.add(n3);

		cloneGraph(n1);
	}

}

class Node {
	public int val;
	public List<Node> neighbors;

	@Override
	public String toString() {
		return "Node [val=" + val + ", neighbors=" + neighbors + "]";
	}
}