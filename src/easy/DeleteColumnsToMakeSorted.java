package easy;

/*
    We are given an array A of N lowercase letter strings, all of the same length.

    Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

    Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in non-decreasing sorted order.

    Return the minimum possible value of D.length.
 */
public class DeleteColumnsToMakeSorted {

    public static void main(String... args) {

        String[] A = {"cba", "daf", "ghi"};
        DeleteColumnsToMakeSorted deleteColumnsToMakeSorted = new DeleteColumnsToMakeSorted();
        System.out.println(deleteColumnsToMakeSorted.minDeletionSize(A));
    }

    public int minDeletionSize(String[] A) {

        int m = A.length;
        int n = A[0].length();
        int result = n;

        for (int i = 0; i < n; i++) {

            boolean flag = true;

            for (int j = 1; j < m; j++)
                if (A[j-1].charAt(i) > A[j].charAt(i)) {
                    flag = false;
                    break;
                }

            if (flag) result--;
        }

        return result;
    }

}
