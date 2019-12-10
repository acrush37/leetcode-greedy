package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

    Return any permutation of A that maximizes its advantage with respect to B.
 */
public class AdvantageShuffle {

    public static void main(String... args) {

        int[] A = {15448, 14234, 13574, 19893, 6475};
        int[] B = {14234, 6475, 19893, 15448, 13574};
        AdvantageShuffle advantageShuffle = new AdvantageShuffle();
        System.out.println(advantageShuffle.advantageCount(A, B));
    }

    public int[] advantageCount(int[] A, int[] B) {

        int n = A.length;
        int[] result = new int[n];
        List<Integer> a = new ArrayList<>();
        for (int x : A) a.add(x);
        Collections.sort(a);

        for (int i = 0; i < n; i++) {

            int j = 0, k = a.size(), p = 0, min = Integer.MAX_VALUE;

            while (j < k && a.get(j) <= B[i]) {

                int x = a.get(j);

                if (x < min) {
                    min = x;
                    p = j;
                }

                j++;
            }

            j = j == k ? p : j;
            result[i] = a.get(j);
            a.remove(j);
        }

        return result;
    }

}
