package dsalgo.common;

public class Entry {
	public int key;
	public int diff;

	public Entry(int key, int diff) {
		this.key = key;
		this.diff = diff;
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", diff=" + diff + "]";
	}

}
