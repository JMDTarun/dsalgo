package dsalgo.leetcode.medium;

import java.util.ArrayDeque;
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
			List<Node> neighbors = poll.neighbors;
			for (Node n : neighbors) {
				if (!map.containsKey(n)) {
					clonedNode = new Node();
					clonedNode.val = poll.val;
					clonedNode.neighbors = new ArrayList<Node>();
					map.put(n, clonedNode);
					queue.add(n);
				}
				map.get(poll).neighbors.add(map.get(n));
			}
		}

		return clonedNode;
	}

	public static Node cloneGraph1(Node node) {
		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new ArrayDeque<>();

		queue.offer(node);

		Node clonedNode = new Node();
		clonedNode.val = node.val;
		clonedNode.neighbors = new ArrayList<Node>();

		map.put(node, clonedNode);
		while (!queue.isEmpty()) {
			Node h = queue.poll();

			for (Node neighbor : h.neighbors) {
				if (!map.containsKey(neighbor)) {
					Node temp = new Node();
					temp.val = node.val;
					temp.neighbors = new ArrayList<Node>();
					map.put(neighbor, temp);
					queue.offer(neighbor);
				}
				map.get(h).neighbors.add(map.get(neighbor));
			}
		}

		return map.get(node);
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

		Node cloneGraph = cloneGraph1(n1);
		System.out.println(cloneGraph);
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