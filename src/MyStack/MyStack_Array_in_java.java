package MyStack;
import java.util.Stack;
public class MyStack_Array_in_java {

        public static void main(String[] args) {
            Stack<String> st = new Stack<String>();
            st.add("first");
            st.add("second");
            st.add("third");
            System.out.println("size: "+st.size());
            System.out.println(st.elementAt(2));
            st.remove(0);
            st.remove("third");
            System.out.println("size: "+st.size());
            System.out.println(st.elementAt(0));
            /*OUTPUT:

            * size: 3
            * third
            * size: 1
            * second
            */
        }

    }
