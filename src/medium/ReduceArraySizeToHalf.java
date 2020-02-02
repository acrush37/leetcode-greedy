package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

    Return the minimum size of the set so that at least half of the integers of the array are removed.
 */
public class ReduceArraySizeToHalf {

    public static void main(String... args) {

        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        ReduceArraySizeToHalf reduceArraySizeToHalf = new ReduceArraySizeToHalf();
        System.out.println(reduceArraySizeToHalf.minSetSize(arr));
    }

    public int minSetSize(int[] arr) {

        int[] f = new int[100001];
        int min = arr[0], max = arr[0];
        List<Integer> t = new ArrayList<>();
        int result = 0, n = arr.length >> 1;

        for (int x : arr) {
            f[x]++;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        for (int i = min; i <= max; i++)
            if (f[i] > 0)
                t.add(f[i]);

        t.sort(Comparator.reverseOrder());

        for (int x : t) {
            result++;
            if ((n -= x) <= 0) return result;
        }

        return 0;
    }

}
