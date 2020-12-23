package BinomialHeap;

import java.util.ArrayList;

public class BinomialTree {

    public String                   job_description;
    public int                      priority;
    public BinomialTree             parent;
    public ArrayList<BinomialTree>  children;
    public int                      degree;

    public BinomialTree(String job_description, int priority) {
        this.job_description = job_description;
        this.priority = priority;
        this.degree = 0;
        parent = null;
        children = new ArrayList<>();
    }

    /**
     * This function merges two binomial trees of the same degree while maintaining the max-heap property.
     *
     * Precondition:    (1) Both t1, t2 are not null trees.
     *                  (2) t1.degree = t2.degree
     *
     * Postcondition:   New tree has degree of t1.degree + 1 and it maintains the max-heap property.
     *
     * Performance:     O(1)
     *
     * Important:       In case of t1 == null or t2 == null or t1.degree != t2.degree, the behaviour of the function
     *                  is undefined.
     *
     * @param t1    Binomial tree
     * @param t2    Binomial tree
     * @return      Merged tree that maintain the max-heap condition.
     */
    public static BinomialTree merge_trees(BinomialTree t1, BinomialTree t2) {
        if(t1.priority < t2.priority) {
            t2.children.add(t1);
            t1.parent = t2;
            t2.degree += 1;
            return t2;
        } else {
            t1.children.add(t2);
            t2.parent = t1;
            t1.degree += 1;
            return t1;
        }
    }

    /**
     * @return  Returns string representation of the tree.
     */
    public String get_string() {
        String repr = "Node: [ job: " + job_description + ", priority: " + priority + "]\n";
        for(BinomialTree child: children) {
            repr = repr.concat("  " + child.get_string() + "\n");
        }
        return repr;

    }
}
