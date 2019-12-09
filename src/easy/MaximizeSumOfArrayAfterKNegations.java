package easy;

import java.util.Arrays;

/*
    Given an array A of integers, we must modify the array in the following way:
    we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
    (We may choose the same index i multiple times.)

    Return the largest possible sum of the array after modifying it in this way.
 */
public class MaximizeSumOfArrayAfterKNegations {

    public static void main(String... args) {

        int[] A = {3, -1, 0, 2};
        MaximizeSumOfArrayAfterKNegations maximizeSumOfArrayAfterKNegations = new MaximizeSumOfArrayAfterKNegations();
        System.out.println(maximizeSumOfArrayAfterKNegations.largestSumAfterKNegations(A, 3));
    }

    public int largestSumAfterKNegations(int[] A, int K) {

        Arrays.sort(A);
        int result = 0;
        int negative = 0;
        int min = Math.abs(A[0]);

        for (int x : A) {
            min = Math.min(min, Math.abs(x));
            if (x < 0) negative++;
            result += x;
        }

        for (int i = 0; i < Math.min(negative, K); i++) result -= A[i] << 1;
        K -= negative;
        return K > 0 && (K & 1) == 1 ? result - (min << 1) : result;
    }

}
