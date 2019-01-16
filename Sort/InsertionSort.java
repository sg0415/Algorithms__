
public class InsertionSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {4, 1431, 5, 234, 11, 6, 2, 3, 222, 1};
		System.out.println("정렬 전");		
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+" ");
		}
		insertionSort(array);
		System.out.println("\n");
		System.out.println("정렬 후");
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+" ");
		}
	}

	public static void insertionSort(int[] array){
		int key, index = 0;
		int size = array.length;	
		
		for(int i = 1; i < size; i++) {
			key = array[i];
			index = i-1;
			
			while(index >=0 && array[index] > key) {
				array[index+1] = array[index];
				index--;
			}
			array[index+1] = key;
			
		}
		
	}
}
