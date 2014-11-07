import java.util.ArrayList;

public class MaxSubarray {
	private int max_left = 0;
	private int max_right = 0;
	GetResult output2;
	
	public MaxSubarray() {
		System.out.println(" Calling constructor of MaxSubarray ");
	}
	
	
	GetResult FindMaxCrossSubarray(ArrayList<Integer> A, 
														int low, int mid, int high) {
		int left_sum = Integer.MAX_VALUE + 1;
		int right_sum = Integer.MAX_VALUE + 1;
		int sum = 0;
		
		for (int i = mid; i >= low; i--) {
			sum = sum + A.get(i).intValue();
			if ( sum > left_sum ) {
				left_sum = sum;
				max_left = i;
			}
		}
		
		sum = 0;
		for (int j = mid + 1; j <= high; j++) {
			sum = sum + A.get(j).intValue();
			if ( sum > right_sum ) {
				max_right = j;		
				right_sum = sum;
			}
		}
		
		return GetResult.Result(max_left, max_right, left_sum + right_sum);
	}

	
	GetResult FindMaxSubarray(ArrayList<Integer> A, int low, int high) {
		int mid = 0;
		int left_low, left_high, left_sum;
		int right_low, right_high, right_sum;
		int cross_low, cross_high, cross_sum;
		
		if ( high == low )
			return GetResult.Result(low, high, A.get(low).intValue());
		else {
			mid = (low + high)/2;
			output2 = FindMaxSubarray(A, low, mid);
			left_low = output2.getMaxLeft();
			left_high = output2.getMaxRight();
			left_sum = output2.getSum();
			
			output2 = FindMaxSubarray(A, mid + 1, high);
			right_low = output2.getMaxLeft();
			right_high = output2.getMaxRight();
			right_sum = output2.getSum();
			System.out.println("\nright_low: " + right_low + " right_high: " + right_high + " sum: " + right_sum);
			
			output2 = FindMaxCrossSubarray(A, low, mid, high);
			cross_low = output2.getMaxLeft();
			cross_high = output2.getMaxRight();
			cross_sum = output2.getSum();
			
			if ( left_sum >= right_sum && left_sum >= cross_sum )
				return GetResult.Result(left_low, left_high, left_sum);
			else if ( right_sum >= left_sum && right_sum >= cross_sum )
				return GetResult.Result(right_low, right_high, right_sum);
			else
				return GetResult.Result(cross_low, cross_high, cross_sum);
		}
			
	}
	
}
