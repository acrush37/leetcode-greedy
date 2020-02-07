package medium;

import java.util.ArrayList;
import java.util.List;

/*
    We have a set of items: the i-th item has value values[i] and label labels[i].
    Then, we choose a subset S of these items, such that:

    |S| <= num_wanted
    For every label L, the number of items in S with label L is <= use_limit.

    Return the largest possible sum of the subset S.
 */
public class LargestValuesFromLabels {

    public static void main(String... args) {

        int[] values = {9, 8, 8, 7, 6};
        int[] labels = {0, 0, 0, 1, 1};
        LargestValuesFromLabels largestValuesFromLabels = new LargestValuesFromLabels();
        System.out.println(largestValuesFromLabels.largestValsFromLabels(values, labels, 3, 2));
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        int result = 0, max = 0;
        List<Integer>[] t = new List[20001];
        int[] f = new int[20001], g = new int[20001];

        for (int i = 0; i < values.length; i++) {

            f[values[i]]++;
            max = Math.max(max, values[i]);
            if (t[values[i]] == null) t[values[i]] = new ArrayList<>();
            t[values[i]].add(labels[i]);
        }

        for (int i = max; i >= 0; i--)
            if (f[i] > 0)
                for (int j : t[i])
                    if (g[j] != use_limit) {

                        g[j]++;
                        result += i;
                        if (--num_wanted == 0) return result;
                    }

        return result;
    }

}
