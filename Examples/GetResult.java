
public class GetResult {
	private int max_left = 0;
	private int max_right = 0;
	private int sum = 0;
	
	public GetResult(int left, int right, int sum) {
		this.max_left = left;
		this.max_right = right;
		this.sum = sum;
	}
	
	public final int getMaxLeft() {
		return max_left;
	}
	
	public final int getMaxRight() {
		return max_right;
	}
	
	public final int getSum() {
		return sum;
	}

	public static GetResult Result(int left, int right, int sum) {
		return new GetResult(left, right, sum );
	}
}

