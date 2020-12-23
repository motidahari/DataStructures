package MyStack;
import java.util.Stack;

public class test_MyStack {

        public static void main(String[] args) {
            MyStack_Array_String stack = new MyStack_Array_String();
            stack.push("first");
            stack.push("second");
            stack.push("third");
            System.out.println("size: "+stack.size());
            String str = stack.pop();
            String str2 = stack.pop();
            System.out.println("del: "+str);
            System.out.println("del: "+str2);
            System.out.println("size: "+stack.size());
            System.out.println("size: "+stack.size());
            System.out.println("size: "+stack.toString());

        }

    }
