package BinomialHeap;

import java.util.ArrayList;

public class MaxHeap<T> {

    private ArrayList<PriorityNode<T>> heap;
    private final int MINUS_INFINITY = Integer.MIN_VALUE;


    /**
     * Default c'tor
     */
    public MaxHeap() {
        heap = new ArrayList<>();
        heap.add(null);
    }

    /**
     * The function gets values and their priorities and constructs max heap. This is the
     * build_heap function.
     *
     * Precondition: the size of `values' array is equal to the size of 'priorities' array.
     *
     * Performance: O(n)
     *
     * @param values        The values array
     * @param priorities    The priorities array
     * @param n             The size of values and priorities array
     */
    public MaxHeap(T[] values, int[] priorities, int n) {
        heap = new ArrayList<>();
        heap.add(null);

        for(int i = 0; i < n; i++) {
            heap.add(new PriorityNode<T>(values[i], priorities[i]));
        }

        for (int i = heap.size() - 1; i >= 1; i--) {
            max_heapify(i);
        }
    }

    /**
     * This is helper function. It looks for the node with specified value.
     *
     * Performance: this function works at O(n), where n is the current size
     * of the heap.
     *
     * @param value     The value we query for.
     * @return          If it finds the value in heap then it returns the
     *                  PriorityNode which holds that value. Otherwise, it
     *                  return null. Therefore, the check for null is required.
     */
    private int contains_(T value) {
        for(int i = 1; i < heap.size(); i++) {
            if(heap.get(i).get_value() == value) {
                return i;
            }
        }
        return 0;
    }

    private void swap_(int i, int j) {
        PriorityNode<T> temp_ = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp_);
    }

    private void max_heapify(int index) {
        int largest = index;
        int left = index * 2;
        int right = index * 2 + 1;
        if(left < heap.size() &&
                heap.get(left).get_priority() > heap.get(index).get_priority()) {
            largest = left;
        }
        if(right < heap.size() &&
                heap.get(right).get_priority() > heap.get(largest).get_priority()) {
            largest = right;
        }
        if(largest != index){
            swap_(index, largest);
            max_heapify(largest);
        }
    }

    private int parent_(int index) {
        return (int) (Math.floor(index/2));
    }

    /**
     * This function increments the key of some specific value inside the heap.
     *
     * Precondition: The heap is max heap.
     * Postcondition: The heap is max heap.
     *
     * Performance: O(log n), where n is the size of the heap.
     *
     * @param index             The index of the node that should be increased.
     * @param new_priority      The value we should increase the node by.
     */
    private void increase_priority_(int index, int new_priority) {
        if(heap.get(index).get_priority() < new_priority) {
            heap.get(index).change_priority(new_priority);
            while(index > 1 &&
                    heap.get(parent_(index)).get_priority()
                            < heap.get(index).get_priority()) {
                swap_(index, parent_(index));
                index = parent_(index);
            }
        }

    }

    /**
     * This function queries whether some value exists inside the heap.
     *
     * Performance: this function works at O(n), where n is the current size
     * of the heap.
     *
     * @param value     The value we query for.
     * @return          True, if and only if the value is found inside the heap.
     */
    public boolean contains(T value) {
        return contains_(value) > 0;
    }

    /**
     * This function increments the priority of value element inside the heap.
     *
     * Performance: It worst case scenario - O(n).
     *
     * @param value             The value of the element we want to increase.
     * @param new_priority      The value we want to increase by.
     */
    public void increase_priority(T value, int new_priority) {
        int found_index = contains_(value); // O(n)
        if(found_index > -1) increase_priority_(found_index, new_priority); // O(log n)
    }

    /**
     * This function lets you to Peek on the 'top' of the priority queue, but it
     * does not erases this element from the queue.
     *
     * @return          The maximum value currently inside the heap.
     */
    public T max() {
        return heap.get(1).get_value();
    }

    /**
     * This function returns and erases the maximal element from the queue.
     *
     * @return      The maximal value currently inside the heap.
     */
    public T extract_max() {
        T max_ = max();
        PriorityNode<T> node_ = heap.remove(heap.size() - 1);   // O(1)-amortized
        if(heap.size() > 1) {
            heap.set(1, node_);
            max_heapify(1);
        }
        return max_;
    }

    /**
     * The function inserts new value into the heap, while remaining the heap as
     * max heap.
     *
     * Precondition: The heap is max heap.
     * Postcondition: The heap is max heap.
     *
     * Performance: O(log n), where n is the size of the heap.
     *
     * @param value     The new value that should be inserted into the heap.
     * @param priority  The priority of the value that is inserted.
     */
    public void insert(T value, int priority) {
        heap.add(new PriorityNode<T>(value, MINUS_INFINITY));  // O(1)-amortized
        increase_priority_(heap.size() - 1, priority);    // O(log n)
    }

    /**
     * Should be used for debugging purposes only.
     */
    public void print() {
        for(PriorityNode<T> node_: heap) {
            if (node_ != null) System.out.println(node_.toString());
        }
    }

    /**
     * Not good implementation. Runs in O(n log n).
     */
    public static <T> MaxHeap build_heap(T[] values, int[] priorities, int n){
        MaxHeap<T> heap = new MaxHeap<T>();
        for(int i = 0; i < n; i++){
            heap.insert(values[i], priorities[i]);
        }
        return heap;
    }
}
