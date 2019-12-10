package medium;

/*
    Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

    (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 */
public class MonotoneIncreasingDigits {

    public static void main(String... args) {

        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(101));
    }

    public int monotoneIncreasingDigits(int N) {

        char[] c = (N + "").toCharArray();
        int n = c.length - 1;
        if (n == 0) return N;

        for (int i = 0; i < n; i++)
            if (c[i] > c[i+1]) {

                while (i >= 1 && c[i] == c[i-1]) i--;
                c[i] -= 1;
                for (int j = i+1; j <= n; j++) c[j] = '9';
                return Integer.parseInt(String.valueOf(c));
            }

        return N;
    }

}
