
public class BubbleSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4, 1431, 5, 234, 11, 6, 2, 3, 222, 1};
		System.out.println("정렬 전");		
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+" ");
		}
		bubbleSort(array);
		System.out.println("\n");
		System.out.println("정렬 후");
		for(int i = 0; i <= array.length-1; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void bubbleSort(int[] array) {
		int size = array.length;
		
		for(int i = 0; i < size-1; i++) {
			for(int j = 0; j < size-1; j++) {
				if(array[j] > array[j+1]) {
					int temp;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
