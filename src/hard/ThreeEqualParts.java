package hard;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent the same binary value.
    If it is possible, return any [i, j] with i+1 < j, such that:

    A[0], A[1], ..., A[i] is the first part;
    A[i+1], A[i+2], ..., A[j-1] is the second part, and
    A[j], A[j+1], ..., A[A.length - 1] is the third part.

    All three parts have equal binary value. If it is not possible, return [-1, -1].
 */
public class ThreeEqualParts {

    public static void main(String... args) {

        int[] A = {0,1,0,1,1,0,0,1,0,1,0,0,0,0,1,0,1,1,1,0};
        ThreeEqualParts threeEqualParts = new ThreeEqualParts();
        System.out.println(threeEqualParts.threeEqualParts(A));
    }

    public int[] threeEqualParts(int[] A) {

        int n = A.length;
        List<Integer> t = new ArrayList<>();
        for (int i = 0; i < n; i++) if (A[i] == 1) t.add(i);
        int m = t.size();
        if (m % 3 != 0) return new int[]{-1, -1};
        if ((m /= 3) == 0) return new int[]{0, 2};
        int x = 0, y = m, z = m << 1;

        for (int i = 1; i < m; i++) {

            int a = t.get(x+1) - t.get(x++);
            int b = t.get(y+1) - t.get(y++);
            int c = t.get(z+1) - t.get(z++);
            if (a != b || a != c) return new int[]{-1, -1};
        }

        m = n - t.get(t.size()-1);
        if (t.get(x+1) - t.get(x) < m) return new int[]{-1, -1};
        if (t.get(y+1) - t.get(y) < m) return new int[]{-1, -1};
        return new int[]{t.get(x) + m - 1, t.get(y) + m};
    }

}
