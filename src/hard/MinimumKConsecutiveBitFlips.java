package hard;

/*
    In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of
    length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.

    Return the minimum number of K-bit flips required so that there is no 0 in the array.
    If it is not possible, return -1.
 */
public class MinimumKConsecutiveBitFlips {

    public static void main(String... args) {

        int[] A = {0, 0, 0, 1, 0, 1, 1, 0};
        MinimumKConsecutiveBitFlips minimumKConsecutiveBitFlips = new MinimumKConsecutiveBitFlips();
        System.out.println(minimumKConsecutiveBitFlips.minKBitFlips(A, 3));
    }

    public int minKBitFlips(int[] A, int K) {

        int result = 0, n = A.length;

        for (int i = 0; i <= n-K; i++)
            if (A[i] == 0) {
                result++;
                for (int j = i+1; j < i+K; j++) A[j] ^= 1;
            }

        for (int i = n-K+1; i < n; i++)
            if (A[i] == 0)
                return -1;

        return result;
    }

}
