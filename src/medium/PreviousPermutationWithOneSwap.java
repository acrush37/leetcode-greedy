package medium;

import java.util.Arrays;

/*
    Given an array A of positive integers (not necessarily distinct), return the
    lexicographically largest permutation that is smaller than A, that can be made
    with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).

    If it cannot be done, then return the same array.
 */
public class PreviousPermutationWithOneSwap {

    public static void main(String... args) {

        int[] A = {3, 2, 1};
        PreviousPermutationWithOneSwap previousPermutationWithOneSwap = new PreviousPermutationWithOneSwap();
        System.out.println(previousPermutationWithOneSwap.prevPermOpt1(A));
    }

    public int[] prevPermOpt1(int[] A) {

        int n = A.length-1;
        while (n >= 1 && A[n] >= A[n-1]) n--;
        if (n == 0) return A;
        int t = A[n];
        int p = n;

        for (int i = n+1; i < A.length; i++)
            if (A[i] < A[n-1] && A[i] > t) {
                p = i;
                t = A[i];
            }

        t = A[n-1];
        A[n-1] = A[p];
        A[p] = t;
        return A;
    }

}
