package dsalgo.easy.grokking.topkelements.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import dsalgo.common.Point;

public class KClosestPointsToTheOrigin {

	public static List<Point> findClosestPoints(List<Point> points, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
		int i = 0;
		for (; i < k; i++) {
			maxHeap.add(points.get(i));
		}
		for (; i < points.size(); i++) {
			if (points.get(i).distFromOrigin() < maxHeap.peek().distFromOrigin()) {
				maxHeap.poll();
				maxHeap.add(points.get(i));
			}
		}
		return new ArrayList<>(maxHeap);
	}

	public static void main(String[] args) {
		List<Point> points = new ArrayList<>();
		points.add(new Point(1, 3));
		points.add(new Point(3, 4));
		points.add(new Point(2, -1));
		List<Point> findClosestPoints = findClosestPoints(points, 2);
		for (Point p : findClosestPoints) {
			System.out.println("[" + p.getX() + ", " + p.getY() + "]");
		}
	}

}
