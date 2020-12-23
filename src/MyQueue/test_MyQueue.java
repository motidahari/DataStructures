package MyQueue;

public class test_MyQueue {

        public static void main(String[] args) {
            Queue_Array_String queue = new Queue_Array_String();
            queue.enqueue("1");
            queue.enqueue("2");
            queue.enqueue("3");
            queue.enqueue("4");
            queue.enqueue("5");
            queue.enqueue("6");
            queue.enqueue("7");
            System.out.println(queue.toString());
            System.out.println("is empty? "+queue.IsEmpty());

            System.out.println("del: "+ queue.dequeue());
            System.out.println("del: "+ queue.dequeue());
            System.out.println("del: "+ queue.dequeue());
            System.out.println("del: "+ queue.dequeue());
            System.out.println("del: "+ queue.dequeue());
            System.out.println("del: "+ queue.dequeue());
            System.out.println("del: "+ queue.dequeue());
            System.out.println("del: "+ queue.dequeue());

            System.out.println("is empty? = "+queue.IsEmpty());
            System.out.println(queue.toString());

        }

    }
