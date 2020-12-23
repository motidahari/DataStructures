package MyQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
public class MyQueue_Array_in_java {
        /**
         * FIFO blocking queue where the elements are stored
         * in an fixed size array.
         * The array buffer is circular, sometimes called a squirrel cage
         * buffer. When the array fills up it wraps around to the beginning
         * being careful not to overwrite existing elements.
         * If all goes well, the oldest elements are popped off in time
         * to create room for new elements, hot on their heels.
         */
        public static void main(String[] args) {
            Queue<String> q = new ArrayBlockingQueue<String>(3);
            q.poll();
            try{
                System.out.print(q.offer("x")+", ");
                System.out.print(q.add("b")+", ");
                System.out.println(q.add("c"));
                System.out.println(q.offer("d"));
            }
            catch(IllegalStateException e){
                e.printStackTrace();
            }
            Iterator<String> iter = q.iterator();
            while(iter.hasNext()){
                System.out.print(iter.next()+", " );
            }
            System.out.println("size = "+q.size());
            System.out.print(q.poll()+", ");
            System.out.print(q.poll()+", ");
            try{
                System.out.print(q.remove()+", ");
                System.out.print(q.remove()+", ");
            }
            catch(IllegalStateException e){
                e.printStackTrace();
            }
            System.out.println(q.poll());
        }
    }



