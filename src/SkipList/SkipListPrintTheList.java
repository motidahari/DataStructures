package SkipList;
import java.util.Scanner;
import java.util.Arrays;

public class SkipListPrintTheList {

    public static void print(int[] arr) {
        int level = 0, index = 0, i = 0, length = arr.length;
        int[] newArr = new int[0];

        String str = "null <-> ";
        while (i < length) {
            str += arr[i] + " <-> ";
            if(i%2 != 0){
                newArr = Arrays.copyOf(newArr, newArr.length + 1);
                newArr[index++] = arr[i];
            }//{0->1,1->3,2->5,3->6,8,5->9,11,7->12,15}
            i++;
        }

        System.out.print("level = " + level +"  " );
        System.out.print(str + "null");
        System.out.println();
        print2(newArr,level+1);
    }
    public static int[] print2(int[] arr,int level) {
        if( arr.length == 0) return new int[0];
        int index = 0, i = 0, length = arr.length;

        int[] newArr = new int[0];
        String str = "null <-> ";
        while (i < length ) {
            str += arr[i] + " <-> ";
            if(i%2 != 0){
                newArr = Arrays.copyOf(newArr, newArr.length + 1);
                newArr[index++] = arr[i];
            }
            i++;
        }
        System.out.print("level = " + level +"  " );
        System.out.print(str + "null");
        System.out.println();
        return print2(newArr,level+1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        print(arr);
    }
}