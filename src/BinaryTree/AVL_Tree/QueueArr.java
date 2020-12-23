package BinaryTree.AVL_Tree;
/**
 *  
 * Queue data structure class (for BFS) - Data structures course, Ariel University - 2020.
 * @author Asaly Saed, saed.asaly@gmail.com
 */
public class QueueArr<T> {
	Node[] Queue;
	int front, rear;
	int MaxSize;
	/**
	 * return an empty queue with size MaxSize
	 * @param MaxSize the maximum number of elements the queue can contain
	 */
	public QueueArr(int MaxSize) {
		this.MaxSize = MaxSize;
		Queue = new Node[MaxSize];
		front = rear = -1;
	}
	/**
	 * 
	 * @return true, if the queue is empty, and false otherwise.
	 */
	public boolean IsEmpty() {
		return ((front == -1) && (rear == -1));
	}
	/**
	 * 
	 * @return true, if the queue is full, and false otherwise.
	 */
	public boolean IsFull() {
		return ((rear + 1) % MaxSize == front);
	}
	/**
	 * 
	 * @param data to be added to the queue
	 * @return true if the data has been added, false otherwise.
	 */
	public boolean Enqueue(Node data) {
		if (IsEmpty()) {
			front = rear = 0;
			Queue[front] = data;
		} else if (IsFull()) {
			return false;
		} else {
			rear = (rear + 1) % MaxSize;
			Queue[rear] = data;
		}
		return true;
	}
	/**
	 * 
	 * @return The first element of the queue after removing it.
	 */
	public Node Dequeue() {
		Node tmp;
		if (IsEmpty()) {
			return null;
		} else if (rear == front) {
			tmp = Queue[rear];
			rear = front = -1;
		} else {
			tmp = Queue[front];
			front = (front + 1) % MaxSize;
		}
		return tmp;
	}
	/**
	 * 
	 * @return The first element in the queue (without removing it).
	 */
	public Node getFront() {
		return (front!=-1)?Queue[front]:null;
	}
	/**
	 * 
	 * @return The last element in the queue.
	 */
	public Node getRear() {
		return (rear!=-1)?Queue[rear]:null;
	}
	/**
	 * @return A string describing the queue elements.
	 */
	public String toString() {
		String st="";
		for(int i=front;i<rear;i=(i+1)%MaxSize) {
			st+=Queue[i]+", ";
		}
		if(rear!=-1) {
			st+=Queue[rear]+"|-";
		}else {
			st+="|-";
		}
		return st;
	}
}
