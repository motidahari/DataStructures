package LinkedLists;
/**
 *
 * @author Asaly Saed
 * Single Linked list class - Data structures course, Ariel University - 2020.
 */

public class LinkedList {
    public Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void AddLast(int data) {
        if (size == 0) {
            head = new Node(data, null);
            size = 1;
        } else {
            Node p = head;
            while (p.getNext() != null) {
                p = p.getNext();
            }
            Node newNode = new Node(data, null);
            p.setNext(newNode);
            size++;
        }
    }

    public Node Remove(int data) {
        if (head.getData() == data) {
            Node tmp = head;
            head = head.getNext();
            size--;
            return tmp;
        }
        Node p = head;
        while (p.getNext() != null && p.getNext().getData() != data) {
            p = p.getNext();
        }
        if (p.getNext() != null) {
            Node tmp = p.getNext();
            p.setNext(p.getNext().getNext());
            size--;
            return tmp;
        }
        return null;
    }

    public void RemoveAllOccurences(int data) {
        Node p=Remove(data);
        while(p!=null) {
            p=Remove(data);
        }
    }

    public String toString() {
        if (size == 0)
            return "-> null";
        Node p = head;
        String st = "-> ";
        while (p.getNext() != null) {
            st += p.getData() + " -> ";
            p = p.getNext();
        }
        st += p.getData() + " -> null";
        return st;

    }

}
