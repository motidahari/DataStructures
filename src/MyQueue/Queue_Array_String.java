package MyQueue;

public class Queue_Array_String {

    String[] Queue;
    int front, rear;
    int Maxsize = 10;

    public Queue_Array_String() {
        Queue = new String[Maxsize];
        front = rear = -1;
    }
    public Queue_Array_String(int MaxSize) {
        this.Maxsize = MaxSize;
        Queue = new String[MaxSize];
        front = rear = -1;
    }
    public boolean IsEmpty(){
        return ((front==-1)&&(rear==-1));
    }
    public boolean IsFull(){
        return ((rear+1)%Maxsize==front);
    }

    public boolean enqueue(String data){
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
    public String dequeue(){
        String tmp;
        if(IsEmpty())
            return "" + Integer.MAX_VALUE;
        else if(rear==front){
            tmp=Queue[rear];
            rear=front=-1;
        }else{
            tmp=Queue[front];
            front=(front+1)%Maxsize;
        }
        return tmp;
    }
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
