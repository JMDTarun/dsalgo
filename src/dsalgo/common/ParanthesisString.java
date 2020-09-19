package dsalgo.common;

public class ParanthesisString {
	public int openCount;
	public int closeCount;
	public String str;

	public ParanthesisString(int openCount, int closeCount, String str) {
		this.openCount = openCount;
		this.closeCount = closeCount;
		this.str = str;
	}

	@Override
	public String toString() {
		return "ParanthesisString [openCount=" + openCount + ", closeCount=" + closeCount + ", str=" + str + "]";
	}

}
