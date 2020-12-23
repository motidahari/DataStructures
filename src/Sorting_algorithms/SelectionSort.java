package Sorting_algorithms;

import java.util.Arrays;

public class SelectionSort {
	
	public static void sort(int[] arr) {
		int n = arr.length;
		
		for(int i = 0 ; i < n - 1 ; i++) {
			int minIndex = i;
			for(int j = i + 1 ; j < n ; j++) 
				if(arr[j] < arr[minIndex])
					minIndex = j;
				
				swap(arr, minIndex, i);
		}
	}
	
	public static void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int arr[] = {64, 25, 12, 22, 11};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
