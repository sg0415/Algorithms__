
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4, 1431, 5, 234, 11, 6, 2, 3, 222, 1};
		int size = array.length;
		int[] temp = new int[size];
		
		System.out.println("정렬 전");		
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+"\t");
		}
		System.out.println("\n");		
		mergeSort(array, temp, 0, size-1);
		System.out.println("");
		System.out.println("정렬 후");
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+"\t");
		}
	
	}
	
	public static void mergeSort(int[] array, int[] temp, int left, int right) {
		int middle;
		middle = (left+right)/2;
		
		if(left < right) {	
			mergeSort(array, temp, left, middle);
			mergeSort(array, temp, middle+1, right);
			merge(array, temp, left, middle, right);
		}
	}
	
	public static void merge(int[] array, int[] temp, int left, int middle, int right) {
		//배열 인덱스
		int i, j, k;
		
		i = left;
		j = middle+1;
		k = left;
		
		while(i<=middle && j<=right) {
			if(array[i] < array[j]) {
				temp[k] = array[i];
				i++;
			}else {
				temp[k] = array[j];
				j++;
			}
			k++;
		}
		
		while(i<=middle) {
			temp[k] = array[i];
			k++; i++;
		}
		
		while(j<=right) {
			temp[k] = array[j];
			k++; j++;
		}
		
		for(int index = left; index <= right; index++) {
			array[index] = temp[index];
		}
		
		for(int t = 0; t <= array.length-1; t++) {
			System.out.print(array[t]+"\t");
		}
		System.out.println("");
	}

}
