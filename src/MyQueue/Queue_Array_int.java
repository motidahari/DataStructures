package MyQueue;

public class Queue_Array_int {

    int[] Queue;
    int front, rear;
    int Maxsize;

    public Queue_Array_int(int MaxSize) {
        this.Maxsize = MaxSize;
        Queue = new int[MaxSize];
        front = rear = -1;
    }
    public boolean IsEmpty(){
        return ((front==-1)&&(rear==-1));
    }
    public boolean IsFull(){
        return ((rear+1)%Maxsize==front);
    }
    //O(1)
    public boolean enqueue(int data){
        if(IsEmpty()){
            front=rear=0;
            Queue[front]=data;
        }else if(IsFull())
            return false;
        else{
            rear=(rear+1)%Maxsize;
            Queue[rear]=data;
        }
        return true;
    }
    /**
     *
     * @return The first element of the queue after removing it.
     */
    //O(1)
    public int dequeue(){
        int tmp;
        if(IsEmpty())
            return Integer.MAX_VALUE;
        else if(rear==front){
            tmp=Queue[rear];
            rear=front=-1;
        }else{
            tmp=Queue[front];
            front=(front+1)%Maxsize;
        }
        return tmp;
    }
    /**
     *
     * @return The first element in the queue (without removing it).
     */
    public int getFront() {
        return (front!=-1)?Queue[front]:-1;
    }
    /**
     *
     * @return The last element in the queue.
     */
    public int getRear() {
        return (rear!=-1)?Queue[rear]:-1;
    }
    /**
     * @return A string describing the queue elements.
     */
    public String toString(){
        String st="";

        for(int i=front;i<rear;i=(i+1)%Maxsize){
            st=st+Queue[i]+", ";
        }
        if(rear!=-1)
            st=st+Queue[rear]+"|-";
        else
            st=st+"|-";
        return st;
    }
    }
