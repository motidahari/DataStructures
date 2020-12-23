package Sorting_algorithms;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int[] array) {
		
		boolean isSorted = false;
		
		while(!isSorted) {
			isSorted = true;
			int lastUnsorted = array.length - 1;
			for(int i = 0 ; i < lastUnsorted ; i++) {
				if(array[i] > array[i + 1]) {
					swap(array, i, i+1);
					isSorted = false;
				}
			}
			lastUnsorted--;
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {6,1,3,2,1,4,9};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
