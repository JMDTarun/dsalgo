package dsalgo.easy.algoexpert.medium;

import java.util.Stack;

public class MinMaxStackConstruction {

	private Stack<Integer> stack = new Stack<Integer>();
	int min = 0;

	public void push(Integer num) {
		if (stack.isEmpty()) {
			stack.push(num);
			min = num;
		} else {
			if (num > min) {
				stack.push(num);
			} else {
				stack.push(2 * num - min);
				min = num;
			}
		}
	}

	public void pop() {
		Integer pop = stack.pop();
		if (pop < min) {
			min = 2 * min - pop;
		}
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinMaxStackConstruction stack = new MinMaxStackConstruction();
		stack.push(8);
		stack.push(10);
		System.out.println(stack.getMin());
		stack.push(6);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

}
