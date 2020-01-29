package medium;

import java.util.Arrays;

/*
    We are given an array A of N lowercase letter strings, all of the same length.
    Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

    Suppose we chose a set of deletion indices D such that after deletions, the final array
    has its elements in lexicographic order (A[0] <= A[1] <= A[2] ... <= A[A.length - 1]).

    Return the minimum possible value of D.length.
 */
public class DeleteColumnsMakeSortedII {

    public static void main(String... args) {

        String[] A = {"zyx", "wvu", "tsr"};
        DeleteColumnsMakeSortedII deleteColumnsMakeSortedII = new DeleteColumnsMakeSortedII();
        System.out.println(deleteColumnsMakeSortedII.minDeletionSize(A));
    }

    public int minDeletionSize(String[] A) {

        int result = 0, n = A.length, m = A[0].length();
        String[] a = new String[n];

        for (int i = 0; i < m; i++) {

            boolean flag = true;
            String[] b = Arrays.copyOf(a, n);
            for (int j = 0; j < n; j++) b[j] += A[j].charAt(i);

            for (int j = 1; j < n; j++)
                if (b[j].compareTo(b[j-1]) < 0) {
                    flag = false;
                    break;
                }

            if (flag) a = b;
            else result++;
        }

        return result;
    }

}
