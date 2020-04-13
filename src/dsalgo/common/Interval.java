package dsalgo.common;

public class Interval {

	public int start;
	public int end;
	
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}
