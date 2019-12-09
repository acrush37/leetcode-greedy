package medium;

/*
    We have a two dimensional matrix A where each value is 0 or 1.

    A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

    After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

    Return the highest possible score.
 */
public class ScoreAfterFlippingMatrix {

    public static void main(String... args) {

        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        ScoreAfterFlippingMatrix scoreAfterFlippingMatrix = new ScoreAfterFlippingMatrix();
        System.out.println(scoreAfterFlippingMatrix.matrixScore(A));
    }

    public int matrixScore(int[][] A) {

        int result = 0;
        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++)
            if (A[i][0] == 0)
                for (int j = 0; j < n; j++)
                    A[i][j] ^= 1;

        for (int i = 0; i < n; i++) {

            int s = 0;
            for (int j = 0; j < m; j++) s += A[j][i];
            result += Math.max(s, m-s) * (1 << (n-i-1));
        }

        return result;
    }

}
