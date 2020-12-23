package Sorting_algorithms;

import java.util.Arrays;

public class MergeSort {

	private static void mergeSort(int[] arr) {
		mergeSort(arr,0,arr.length-1);
	}
	
	private static void mergeSort(int[] arr, int start, int end) {
		if(start < end) {
			int middle = (start+end)/2;
			
			mergeSort(arr,start,middle); // left
			mergeSort(arr,middle+1,end); // right
			Merge(arr,start,middle,end);
		}
	}

	private static void Merge(int[] arr, int start, int middle, int end) {
		
		int[] temp = new int[end - start + 1];
		
		int i = start; // left half
		int j = middle + 1; // right half
		int k = 0; // The Running Pointer
		
		while( i <= middle && j <= end) {
			
			if(arr[i] < arr[j]) 
				temp[k++] = arr[i++];
			else 
				temp[k++] = arr[j++];
		}
		
		while(i <= middle)
			temp[k++] = arr[i++];
		
		while(j <= end)
			temp[k++] = arr[j++];
		
		
		 for(i = start, k = 0 ; k < temp.length && i <= end ; k++, i++)
			 arr[i] = temp[k];
	}
	// Method to test above 
	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4,3,2,1};

		System.out.println(Arrays.toString(arr));
		System.out.println();
		mergeSort(arr); 
		System.out.println(Arrays.toString(arr));
	}
}
