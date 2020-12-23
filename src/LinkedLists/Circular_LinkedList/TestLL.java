package LinkedLists.Circular_LinkedList;

/**
 * 
 * @author Asaly Saed 
 * Single Linked list class simple tester - Data structures course, Ariel University - 2020.
 */
public class TestLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList lst=new CircularLinkedList();
		for(int i = 0 ; i < 10; i++){
			lst.addNode(i/*((int)(Math.random()*100))+1*/);
		}
		System.out.println(lst.toString());


		lst.deleteNode(2);
		lst.deleteNode(4);
		lst.deleteNode(9);
		System.out.println(lst.toString());

		/*
		System.out.println(lst);
		lst.Remove(-23);
		System.out.println(lst);
		lst.Remove(90);
		System.out.println(lst);
		lst.RemoveAllOccurences(12);
		System.out.println(lst);*/
	}

}
