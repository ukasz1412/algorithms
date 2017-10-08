package alg.sort;

public class QuickSort extends Sort {
    @Override
    public int[] sort(int[] input) {
        quickSort(input, 0, input.length - 1);
        return input;
    }

    /**
     * Quicsort algorithm
     * @param input array
     * @param left 1st element
     * @param right the last element
     */
    private void quickSort(int[] input, int left, int right) {
        //Run quick sort if IDs are correct
        if (left < right) {
            //Get pivot ID after partitioning
            int pivotId = partition(input, left, right);

            //Run quick sort for left and right sub-arrays
            quickSort(input, left, pivotId);
            quickSort(input, pivotId + 1, right);
        }
    }

    /**
     * Partition process - reorganize the input array so that smaller elements that the pivot are on the left
     * and greater on the right
     * @param input array
     * @param left 1st element ID
     * @param right the last element ID
     * @return pivot ID after partitioning
     */
    private int partition(int[] input, int left, int right) {
        //Take pivot element as the last from the input
        int pivot = input[right];
        //The current position of the last element smaller than the pivot
        int cLow = left - 1;
        //Starting ID
        int cHigh = left;
        //Repeat unless it reached pivot element (which is the last in the input)
        while (cHigh < right) {
            //If the value of the current element is less or equal to pivot, make sure it's on the left side
            if (input[cHigh] <= pivot) {
                //Increase the ID of element to be swapped
                ++cLow;
                //Swap it, so it's on the left side of the array
                swap(input, cLow, cHigh);
            }
            //Move to the next item
            ++cHigh;
        }
        //At the end swap pivot element so it satisfies assumption that left side is smaller than pivot and right greater
        swap(input, cLow + 1, pivot);
        //Return its ID in the array
        return cLow + 1;
    }
}
