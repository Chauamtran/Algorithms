import java.util.Arrays;
import java.util.List;


public class MergeSort {
	Integer [] array;
	List <Integer> rArray;
	public MergeSort(){
		
	}
	
	void Merge(List<Integer> aArray, int left, int middle, int right) {
		int i, j;
		int n1 = middle - left + 1;
		int n2 = right - middle;
		int [] l = new int[n1 + 1];
		int [] r = new int[n2 + 1];
		
		array = aArray.toArray(new Integer[aArray.size()]);
		
		for ( i = 0; i < n1; i++ ) {
			l[i] = array[left + i].intValue();
		}
		
		for ( j = 0; j < n2; j++ ) {
			r[j] = array[middle + j + 1].intValue();
		}
		
		l[n1] = Integer.MAX_VALUE;
		r[n2] = Integer.MAX_VALUE;
		
		i = 0;
		j = 0;
		
		for ( int k = left; k <= right; k++) {
			if ( l[i] <= r[j] ) {
				array[k] = l[i];
				i++;
			} else {
				array[k] = r[j];
				j++;
			}
		}
		
		rArray = Arrays.asList(array);
	}
	
	List<Integer> Merge_Sort(List<Integer> aArray, int left, int right) {
		if ( left < right ) {
			int q = (( left + right)/2);
			rArray = aArray;
			Merge_Sort(rArray, left, q);
			Merge_Sort(rArray, q + 1, right);
			Merge(rArray, left, q, right);
		} 
		return rArray;
	}
	
}
