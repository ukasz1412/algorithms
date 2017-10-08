package alg.sort;

public class MergeSort extends Sort {
    @Override
    public int[] sort(int[] input) {
        //Start merge sort by specifying the 1st and the last element of the input array
        mergeSort(input, 0, input.length - 1);
        return input;
    }

    /**
     * Run merge sort
     * @param input input array
     * @param left the 1st index
     * @param right the last index
     */
    private void mergeSort(int[] input, int left, int right) {
        //Run merge sort ids are in the correct order
        if (left < right) {
            //Calculate middle element
            int mid = mid(left, right);
            //Run merge sort for both sub-arrays [left ; mid] and [mid + 1 ; right]
            mergeSort(input, left, mid);
            mergeSort(input, mid + 1, right);
            //Merge previously divided array
            merge(input, left, right);
        }
    }

    /**
     * Merges both sub-arrays [left ; mid] and [mid + 1 ; right] withing the input array, by calculating middle element
     * @param input array
     * @param left index of the first element in the first sub-array
     * @param right index of the last element in the secont sub-array
     */
    private void merge(int[] input, int left, int right) {
        //Calculate middel index to split initial array into 2 sub-arrays
        int mid = mid(left, right);
        //Copy left sub-array (don't copy the right one to reduce space required)
        int[] leftTmp = copy(input, left, mid);

        //Current ids for both sub-arrays and the result array which is within the given input
        int cLeft = 0; //starting ID of the left sub-array (copied part of the input)
        int cRight = mid + 1; //starting ID of the right sub-array within the input
        int cResult = left; //starting ID for the result array within the input
        //Copy elements while current ids didn't exceed their sizes
        // ... in other words until any of them is fully copied
        while (cLeft < leftTmp.length && cRight <= right) {
            //Copy left element into result if it's smaller
            if (leftTmp[cLeft] <= input[cRight]) {
                input[cResult] = leftTmp[cLeft];
                //move its index as the element was copied
                ++cLeft;
            } else {
                // otherwise copy right element which is smaller
                input[cResult] = input[cRight];
                //move its index as the element was copied

                ++cRight;
            }
            //move result array index as the element was copied into it
            ++cResult;
        }
        //copy all elements that left in the left sub-array
        while (cLeft < leftTmp.length) {
            input[cResult] = leftTmp[cLeft];
            ++cLeft;
            ++cResult;
        }
        //copy all elements that left in the right sub-array
        while (cRight <= right) {
            input[cResult] = input[cRight];
            ++cRight;
            ++cResult;
        }

    }

    /**
     * Calculate middle index of the sub-array between left and right elements
     * @param left index
     * @param right index
     * @return the index of the middle element
     */
    private int mid(int left, int right) {
        return (left + right) / 2;
    }

    /**
     * Copies part of the array
     * @param input array
     * @param begin the first element to be copied
     * @param end the last element to be copiet
     * @return copy
     */
    private int[] copy(int[] input, int begin, int end) {
        int[] copy = new int[end - begin + 1];
        System.arraycopy(input, begin, copy, 0, copy.length);
        return copy;
    }
}
