package alg.other;

import java.util.Arrays;

public class Merge {
    //assuming non null values
    public static int[] mergeSortedLists(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int a_i = 0, b_i = 0;
        for (int i = 0; i < result.length; i++) {
            if (a_i == a.length) {
                //Copy what's left in B if A is empty or already copied
                copyRest(i, b_i, result, b);
                break;
            }
            if (b_i == b.length) {
                //and the same fo A
                copyRest(i, a_i, result, a);
                break;
            }
            if (a[a_i] < b[b_i]) {
                result[i] = a[a_i];
                ++a_i;
            } else {
                result[i] = b[b_i];
                ++b_i;
            }
        }

        return result;
    }

    private static void copyRest(int start, int from, int[] result, int[] data) {
        for (int i = start, j = from; i < result.length; i++, j++) {
            result[i] = data[j];
        }
    }

    public static void test() {
        int[] a = {1, 3, 4, 7, 9, 11, 55};
        int[] b = {2, 5, 8, 10, 12, 17, 19, 100, 120, 199};
        int[] result = Merge.mergeSortedLists(a, b);
        System.out.println(Arrays.toString(a) + " + " + Arrays.toString(b));
        System.out.println(Arrays.toString(result));
        System.out.println("Sizes: "+ a.length + " + " + b.length + " = " + result.length);

    }
}
