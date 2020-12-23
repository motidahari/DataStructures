package Sorting_algorithms;
import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length -1);
	}
	
	public static void quickSort(int[] array, int left , int right) {
		
		if(left >= right) {
			return;
		} 
		
		int pivot = array[(right + left) / 2];
		System.out.println(pivot);

		int index = partition(array, left, right, pivot);
		
		quickSort(array, left , index - 1);
		quickSort(array, index, right);
	}
	
	public static int partition(int[] array, int left, int right, int pivot) {
		
		while(left <= right) { 
			
			while(array[left] < pivot) 
				left++;
			
			
			while(array[right] > pivot) 
				right--;
			
			
				swap(array, left, right);
				left++;
				right--;
			
			System.out.println(Arrays.toString(array));
		}
		
		return left;  // index = left
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		
		int[] array = {90,80,30};
		System.out.println(Arrays.toString(array));
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
	

}
