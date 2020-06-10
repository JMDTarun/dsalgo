package dsalgo.common;

public class Interval {

	public int start;
	public int end;
	public int index;

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public Interval(int start, int end, int index) {
		super();
		this.start = start;
		this.end = end;
		this.index = index;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}
