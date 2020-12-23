package Sorting_algorithms;
import java.util.*; 

public class RadixSort {

    static void radixsort(int arr[], int n) {

        int m = getMax(arr, n); 

        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
    
    static int getMax(int arr[], int n)  { 
        int mx = arr[0]; 
        for(int i = 1; i < n; i++) 
            if(arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    static void countSort(int arr[], int n, int exp) {
    	
        int output[] = new int[n]; // output array  
        int count[] = new int[getMax(arr, n)]; 
 
        for(int i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 

        for (int i = 1; i < count.length; i++) 
            count[i] += count[i - 1]; 
  
        for (int i = n - 1; i >= 0; i--)  { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            
            count[ (arr[i]/exp)%10 ]--; 
        } 

        for (int i = 0; i < n; i++) 
            arr[i] = output[i]; 
    }
    public static void printDuplicatesInArrayRadixsort(int[] arr){
        radixsort(arr, arr.length); //O(nk)
        System.out.println(Arrays.toString(arr));
        /*for(int i = 0; i < arr.length-1; i ++){ // O(n)
            if(arr[i] == arr[i+1]) {
                System.out.println(arr[i]);
                i += 1;
                while (arr[i] == arr[i + 1])
                    i += 1;
            }
        }*/
    }









    public static void main (String[] args) { 
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(Arrays.toString(arr));
        System.out.println();
        radixsort(arr, arr.length); 
        System.out.println(Arrays.toString(arr));
    } 
}
