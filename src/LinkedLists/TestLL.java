package LinkedLists;
/**
 * 
 * @author Asaly Saed 
 * Single Linked list class simple tester - Data structures course, Ariel University - 2020.
 */
public class TestLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lst=new LinkedList();
		lst.AddLast(2);
		lst.AddLast(12);
		lst.AddLast(47);
		lst.AddLast(-23);
		lst.AddLast(38);
		lst.AddLast(10);
		lst.AddLast(-55);
		lst.AddLast(43);
		lst.AddLast(90);
		lst.AddLast(12);
		lst.AddLast(2);
		lst.AddLast(23);
		lst.AddLast(12);
		lst.AddLast(4);
		lst.AddLast(12);
		System.out.println(lst);
		lst.Remove(-23);
		System.out.println(lst);
		lst.Remove(90);
		System.out.println(lst);
		lst.RemoveAllOccurences(12);
		System.out.println(lst);
	}

}
