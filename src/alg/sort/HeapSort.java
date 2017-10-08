package alg.sort;

public class HeapSort extends Sort {
    @Override
    public int[] sort(int[] input) {
        heapify(input);
        //The ID of the last element in the heap
        int last = input.length - 1;
        //Continue algorithm until there is only a single element in the subtree
        while (last != 0) {
            //Remove the last element in the current heap by replacing it with the current ID of the last element
            swap(input, 0, last);
            //Reduce the heap size so removed element is no longer within a new heap
            --last;
            //Rebuild heap property
            siftDown(input, 0, last);
        }
        return input;
    }

    /**
     * Prepare Max-Heap from the input in-place with O(n) complexity
     * @param input broken heap
     */
    private void heapify(int[] input) {
        // Get the parent ID of the last node (leaf) in the array
        int parent = input.length / 2 - 1;
        //Repeat sifting for all subtrees within the heap
        while (parent >= 0) {
            //Sift down subtree, where parent is a root, to satisfy heap conditions
            siftDown(input, parent, input.length - 1);
            //Move to the next subtree
            parent--;
        }
    }

    /**
     * Sift down subtree to satisfy max-heap conditions - O(log n) complexity
     * @param input array
     * @param parent the parent ID of the last node (leaf) in the array
     * @param lastId the last element in the subtree
     */
    private void siftDown(int[] input, int parent, int lastId) {
        //Current root node of the subtree within input array
        int currentRoot = parent;
        //Repeat sifting down while there is at least one child for the current parent
        while (left(currentRoot) <= lastId) {
            //Save left child as the current maximum - parent should have at least one child
            int maxKid = left(currentRoot);
            int rightKid = right(currentRoot);
            //If right child exists, save the one with greater value
            if (rightKid <= lastId && input[rightKid] > input[maxKid]) {
                maxKid = rightKid;
            }
            //Swap parent with its greater child, if max-heap conditions are not satisfied and ...
            if (input[currentRoot] < input[maxKid]) {
                swap(input, currentRoot, maxKid);
                //... and sift down affected subtree by changing our current root
                currentRoot = maxKid;
            } else {
                //No swap occurred, so elements are in the right order
                break;
            }
        }
    }

    /**
     * @param parentId within a heap
     * @return the ID of the left child for the given parent ID in a heap
     */
    private int left(int parentId) {
        return 2 * parentId + 1;
    }

    /**
     * @param parentId within a heap
     * @return the ID of the right child for the given parent ID in a heap
     */
    private int right(int parentId) {
        return 2 * parentId + 2;
    }
}
