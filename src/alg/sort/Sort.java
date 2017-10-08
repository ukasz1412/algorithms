package alg.sort;

public abstract class Sort {

    /**
     * Swaps 2 elements in the given array
     * @param input array
     * @param i index of the 1st element
     * @param j index of the 2nd element
     */
    protected void swap(int[] input, int i, int j) {
        if (i != j) {
            int tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
        }
    }

    public abstract int[] sort(int input[]);
}
