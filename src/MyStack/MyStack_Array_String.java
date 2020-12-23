package MyStack;

public class MyStack_Array_String {

    final int MAX_SIZE = 5;
        String [] items;
        int current, max;


        public MyStack_Array_String(int max){
            this.max = max;
            items = new String[max];
            current = 0;
        }
        public MyStack_Array_String(){
            max = MAX_SIZE;
            items = new String[max];
            current = 0;
        }
         //O(1)
        //add to stack
        public boolean push(String newVal){
            boolean ans = true;
            if (current == max) ans = false;
            else  items[current++] = newVal;
            return ans;
        }
        //O(1)
        //delete from stack
        public String pop(){
            String result = "" + Integer.MAX_VALUE;
            if (current > 0) result = items[--current];
            return result;
        }
         //O(1)
        //get top value
        public String top(){
            String result = "" + Integer.MAX_VALUE;;
            if (current > 0 )result = items[current-1];
            return result;
        }
        //O(1)
        //clear stack
        public void clear(){
            current = 0;
        }
        //O(1)
        //check if the stack is empty
        public boolean empty(){
            return (current==0);
        }
        //O(1)
        //get size
        public int size(){
            return current;
        }

        public String toString(){
            String result = "";
            for (int i=0; i<current; i++){
                result = result + items[i]+", ";
            }
            return result;
        }

    }
