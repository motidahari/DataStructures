package LinkedLists;
import java.util.LinkedList;
import java.util.Iterator;
/*
*
*
* */
public class Linked_List_fron_Java {
        public static void main(String[] args) {
            LinkedList <String> list = new LinkedList<String>();
            String s="a";
            list.add(s);
            list.add("b");
            list.add("c");
            list.add("d");
            Iterator<String> iter = list.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
            System.out.println("s= "+list.contains(s));
            System.out.println("xyt= "+list.contains("xyt"));
            System.out.println("list(2)= "+list.get(2));
            System.out.println("first= "+list.getFirst());
            System.out.println("last= "+list.getLast());
            System.out.println("index of e= "+list.indexOf("e"));
            System.out.println("is empty= "+list.isEmpty());
            System.out.println("size = "+list.size());
            list.remove(1);
            list.remove("xyz");
            System.out.println("size = "+list.size());
            iter = list.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        }
    }

