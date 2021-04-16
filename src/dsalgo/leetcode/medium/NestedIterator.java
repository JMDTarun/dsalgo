package dsalgo.leetcode.medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack<NestedInteger>();

	public NestedIterator(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.empty()) {
			NestedInteger peek = stack.peek();
			if (peek.isInteger()) {
				return true;
			} else {
				stack.pop();
				for (int i = peek.getList().size() - 1; i >= 0; i--) {
					stack.push(peek.getList().get(i));
				}
			}
		}
		return false;
	}
}

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
