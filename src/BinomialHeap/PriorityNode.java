package BinomialHeap;

public class PriorityNode<T> {
    private T value = null;
    private int priority = 0;

    public PriorityNode(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String toString() {
        return "(value: " + value + ", priority: " + priority + ")";
    }

    public T get_value() {
        return value;
    }

    public int get_priority() {
        return priority;
    }

    public void change_priority(int new_priority) {
        priority = new_priority;
    }
}
