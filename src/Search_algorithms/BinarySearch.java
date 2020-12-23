package Search_algorithms;

import java.util.Arrays;

public class BinarySearch {
//O(log_2(n))
//Binary Search Recursive
	public static int binarySearchRecursive(int arr[], int value){
		if (value<arr[0] || value>arr[arr.length-1]){
			return -1;
		}
		return binary_search_recurs(arr, 0, arr.length-1,value);
	}
	public static int binary_search_recurs(int arr[],int low,int high,int value){
		if (low <= high){
			int mid = (low+high)/2;
			if (value==arr[mid])   return mid;//value was found// value suppose to be on left
			else if (value<arr[mid]) return binary_search_recurs(arr, low, mid-1,value);
			else return binary_search_recurs(arr, mid+1, high,value);// value suppose to be on right
		} else {
			return -1;
		}
	}

	//O(log_2(n))
	//Binary Search non Recursive
	public static int binarySearchInducion(int []arr,int value){
		if (value<arr[0] || value>arr[arr.length-1]){
			return -1;
		}
		int low = 0, high = arr.length-1;
		while (low <=high){
			int middle = (low + high)/2;
			if (arr[middle] == value){//value was found
				return middle;
			}
			// value suppose to be left
			if (value < arr[middle]){
				high = middle-1;
			}
			// value suppose to be right
			else{
				low = middle+1;
			}
		}
		return -1;
	}


	/*
Quick Sort – pseudo-code
partition(A, low, high)
    pivot = low
    low = low + 1
    while (low <= high)
        if (A[low] <= A[pivot]) low = low + 1
        else if (A[high] > A[pivot]) high = high – 1
        else A[high]A[low]
    end-while
    if (high!= pivot) A[high]A[pivot]
    pivot = high
    return pivot
end-partition


Quick-Sort(A, low, high)
    if (low < high) then
       pivot = partition(A, low, high)

       Quick-Sort(A, low, pivot-1)
       Quick-Sort(A, pivot+1, high)
    end-if
end- Quick-Sort
QuickSort(A)
    Quick-Sort(A, 0, length(A)-1)
end-QuickSort


	 */
	public static void main(String[] args) {
		
		 int arr[] = { 2, 3, 4, 10, 40 };
	     int x = 10;
	     System.out.println(Arrays.toString(arr));
	     int result = binarySearchRecursive(arr, x);
	     if(result == -1)
	    	 System.out.println("the element isn't presented in the array");
	     else
	    	 System.out.println("The element is persented at index: " + result);

	     result = binarySearchInducion(arr, x);
		if(result == -1)
			System.out.println("the element isn't presented in the array");
		else
			System.out.println("The element is persented at index: " + result);
	}
}
