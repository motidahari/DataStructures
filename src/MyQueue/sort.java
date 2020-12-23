package MyQueue;
import java.util.LinkedList;
import java.util.Queue;
public class sort {
/*
    public static Queue_Array_int sortQueue(Queue_Array_int queue) {
        int currentNum = 0;
        Queue_Array_int queue2 = new Queue_Array_int();
        int temp = 0;
        int size = 0;
        while(!queue.IsEmpty()){
            queue2.enqueue(queue.dequeue());
            size++;
        }
        for (int i = 1; i <= size; i++) {
            int minimumOfIndex = -1;
            int minimumOfValue = Integer.MAX_VALUE;
            int sizeList = size;
            for (int k = 0; k < sizeList; k++) {
                currentNum = queue2.dequeue();
                if (currentNum <= minimumOfValue && k <= size - i) {
                    minimumOfIndex = k;
                    minimumOfValue = currentNum;
                }
                queue2.enqueue(currentNum);
            }
            int minIndex = minimumOfIndex;
            int minValue = 0;
            sizeList = size;
            for (int j = 0; j < sizeList; j++) {
                currentNum = queue2.dequeue();
                if (j != minIndex)
                    queue2.enqueue(currentNum);
                else
                    minValue = currentNum;
            }
            queue2.enqueue(minValue);
        }
        return queue2;
    }



    //Driver function 
    public static void main(String[] args) {

        Queue_Array_int queue = new Queue_Array_int(4);
        queue.enqueue(30);
        queue.enqueue(11);
        queue.enqueue(15);
        queue.enqueue(4);
        //Sort Queue 
        Queue_Array_int queue2 = sortQueue(queue);

        //print sorted Queue 
        while (!queue2.IsEmpty()) {
            System.out.print(queue2.dequeue() + " ");
        }
    }*/
}