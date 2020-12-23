package Sorting_algorithms;
import java.util.Arrays;

 public class CountingSort {
	
	public static void sort(int[] arr) {

		int output[] = new int[arr.length]; 
		int count[] = new int[7];

		for(int i = 0 ; i < arr.length ; i++) 
			count[arr[i]]++;
		
		
		for(int i = 1 ; i < count.length; i++) 
			count[i] += count[i-1];
 
 
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		
		for(int i = 0 ; i < arr.length ; ++i) 
			arr[i] = output[i];
	}
	
	public static void main(String[] args) {
		  int arr[] = {6, 4, 3, 2, 1, 4, 3, 6, 6, 2, 4, 3, 4}; 
		
		  System.out.println(Arrays.toString(arr));
		  sort(arr);
		  System.out.println();
		  System.out.println();
		  System.out.println(Arrays.toString(arr));
	}

}