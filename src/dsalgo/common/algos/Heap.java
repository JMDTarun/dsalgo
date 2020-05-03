package dsalgo.common.algos;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	// A utility function to print the array
	// representation of Heap
	static void printHeap(int arr[], int n) {
		System.out.println("Array representation of Heap is:");

		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	private static List<Integer> list = new ArrayList<>();

	public static void siftUp(int index) {
		int parentIndex = (index - 1) / 2;
		if (parentIndex < 0 || index == parentIndex) {
			return;
		}
		if (list.get(parentIndex) > list.get(index)) {
			int temp = list.get(parentIndex);
			list.set(parentIndex, list.get(index));
			list.set(index, temp);
		}
		siftUp(parentIndex);
	}

	public static void siftDown(int index) {
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;
		int swapIndex = leftChildIndex;
		if (leftChildIndex < list.size() && rightChildIndex < list.size()) {
			if (list.get(leftChildIndex) < list.get(index) || list.get(rightChildIndex) < list.get(index)) {
				if (list.get(leftChildIndex) > list.get(rightChildIndex)) {
					swapIndex = rightChildIndex;
				}
				int temp = list.get(index);
				list.set(index, list.get(swapIndex));
				list.set(swapIndex, temp);
				siftDown(swapIndex);
			}
		}
	}

	public static void addToList(int num) {
		list.add(num);
		siftUp(list.size() - 1);
	}

	public static void removeFromList(int num) {
		int index = list.indexOf(num);
		list.set(index, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		siftDown(index);
	}

	// Driver Code
	public static void main(String args[]) {
		addToList(10);
		addToList(9);
		addToList(8);
		addToList(7);
		addToList(6);
		addToList(5);
		addToList(4);
		addToList(3);
		addToList(2);
		addToList(1);
		System.out.println(list);
		removeFromList(1);
		System.out.println(list);
		addToList(1);
		System.out.println(list);
	}
}
