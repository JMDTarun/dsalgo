package dsalgo.common;

public class Node {

	public int elementIndex;
	public int arrayIndex;
	public int value;

	public Node(int elementIndex, int arrayIndex, int value) {
		this.elementIndex = elementIndex;
		this.arrayIndex = arrayIndex;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [elementIndex=" + elementIndex + ", arrayIndex=" + arrayIndex + ", value=" + value + "]";
	}

}
