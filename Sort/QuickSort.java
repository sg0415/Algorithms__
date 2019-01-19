
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] array = {4, 1431, 5, 234, 11, 6, 2, 3, 222, 1};
		System.out.println("정렬 전");		
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+" ");
		}
		quickSort(array, 0, 9);
		System.out.println("\n");
		System.out.println("정렬 후");
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+" ");
		}
	}

	public static void quickSort(int[] array, int left, int right) {
		int pivot = array[(left+right)/2];
		int l = left;
		int r = right;
		
		while(l <= r) {
			while(array[l] < pivot) l++;
			while(array[r] > pivot) r--;
			if(l <= r) {
				int temp = array[l];
				array[l] = array[r];
				array[r] = temp;
				l++; r--;
			}
		}
		
		if(left <r) quickSort(array, left, r);
		if(right>l) quickSort(array, l, right);
		
	}
}
