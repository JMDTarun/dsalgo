package dsalgo.common;

public class LinkedList {
	public int value = 0;
	public LinkedList next;

	public LinkedList(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "LinkedList [value=" + value + ", next=" + next + "]";
	}
}
