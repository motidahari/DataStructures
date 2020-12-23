package BinomialHeap;

import java.util.ArrayList;

public class BinomialHeap {
    private ArrayList<BinomialTree>     binomial_trees;
    private int                         max_index;
    public int                          size;

    public BinomialHeap() {
        binomial_trees = new ArrayList<>();
        max_index = -1;
        size = 0;
    }

    /**
     * Function peek on the `top' of the heap to get the maximum element in the heap.
     * The function is getter, the internal state remains the same.
     *
     * Important:       Prior of using the function, the user should check whether the heap is empty or not.
     *
     * Performance:     O(1).
     *
     * @return      The maximum element inside the heap.
     */
    public String get_max() {
        if(size == 0)  return "EmptyHeap";
        return binomial_trees.get(max_index).job_description;
    }

    public String extract_max() {

        // Base case
        if(size == 0)  return get_max();

        BinomialTree max_node = binomial_trees.get(max_index);

        // Delete tree from the heap.
        binomial_trees.set(max_index, null);

        // Spread the children of current tree
        for(BinomialTree tree : max_node.children) {
            if(binomial_trees.get(tree.degree) == null) {
                binomial_trees.set(tree.degree, tree);
            } else {
                insert_merge(tree);
            }
        }
        size -= 1;
        update_max_index();
        return max_node.job_description;
    }

    /**
     * This function takes new element and its priority and inserts it in the right place of the heap.
     *
     * Precondition:    The heap is binomial and maximum-property holds.
     * Postcondition:   The heap is binomial, maximum-property holds and new element is inserted in right place.
     *
     * Performance:     O(log n) where n is the number of elements in the heap.
     *
     * @param job_description   Description of the new element.
     * @param priority          The priority key.
     */
    public void insert(String job_description, int priority) {
        BinomialTree new_tree = new BinomialTree(job_description, priority);
        if(size == 0) {
            binomial_trees.add(new_tree);
            max_index = 0;
        }
        else if (binomial_trees.get(0) == null) {
            binomial_trees.set(0, new_tree);
            update_max_index();         // O(log n)
        }
        else {
            insert_merge(new_tree);     // O(log n)
            update_max_index();         // O(log n)
        }
        size += 1;
    }

    /**
     * Homework!
     * @param job_description
     * @param new_priority
     */
    public void increase_priority(String job_description, int new_priority) {

    }


    /**
     * This function is helper function that accepts tree and merges it with tree of the same degree until there is
     * no more merge availble. This function should be called inside the insert and extract function.
     *
     * @param tree      The tree to merge.
     */
    private void insert_merge(BinomialTree tree) {
        boolean done_inserting = false;
        while(!done_inserting) {
            int degree_= tree.degree;
            tree = BinomialTree.merge_trees(tree, binomial_trees.get(degree_));
            binomial_trees.set(degree_, null);
            if(binomial_trees.size() - 1 < tree.degree) {
                binomial_trees.add(tree);
                done_inserting = true;
            } else if (binomial_trees.get(tree.degree) == null) {
                binomial_trees.set(tree.degree, tree);
                done_inserting = true;
            }
        }
    }

    /**
     * This function responsible for updating the pointer max_index to the index of maximal element.
     *
     * Precondition:    The heap is binomial and maximum heap with n elements in it.
     * Postcondition:   The heap remains binomial, maximum with n elements and max_index points to maximum element.
     *
     * Performance: O(log n) where n is the number of elements in heap.
     */
    private void update_max_index() {
        int max_priority = Integer.MIN_VALUE;
        max_index = -1;
        for(int i = 0; i < Math.min(Math.round(Math.ceil(Math.log(size)/Math.log(2))) + 1, binomial_trees.size()); i++) {
            if(binomial_trees.get(i) != null) {
                if(binomial_trees.get(i).priority > max_priority) {
                    max_priority = binomial_trees.get(i).priority;
                    max_index = i;
                }
            }
        }
    }

    /* For debugging purposes */
    public void print() {
        if(size == 0){
            System.out.println("Empty tree.");
            return;
        }
        for(int i = 0; i < binomial_trees.size(); i++) {
            System.out.println("Deg " + i + ":");
            if(binomial_trees.get(i) == null)
                System.out.println("Empty tree.");
            else
                System.out.println(binomial_trees.get(i).get_string());
        }
    }
}
