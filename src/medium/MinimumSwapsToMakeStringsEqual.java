package medium;

/*
    You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only.
    Your task is to make these two strings equal to each other.
    You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].

    Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.
 */
public class MinimumSwapsToMakeStringsEqual {

    public static void main(String... args) {

        MinimumSwapsToMakeStringsEqual minimumSwapsToMakeStringsEqual = new MinimumSwapsToMakeStringsEqual();
        System.out.println(minimumSwapsToMakeStringsEqual.minimumSwap("yxxxxyxxxxx", "yxxxyxyyxxx"));
    }

    public int minimumSwap(String s1, String s2) {

        int result = 0;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for (char c : a) if (c == 'x') result++;
        for (char c : b) if (c == 'x') result++;
        if ((result & 1) == 1) return -1;
        result = 0;
        int n = a.length, j;
        boolean[] t = new boolean[n];

        for (int i = 0; i < n; i++)
            if (!t[i] && a[i] != b[i]) {

                boolean flag = true;

                for (j = i+1; j < n; j++)
                    if (!t[j] && a[i] == a[j] && b[i] == b[j]) {
                        result++;
                        flag = false;
                        break;
                    }

                if (flag)
                    for (j = i+1; j < n; j++)
                        if (!t[j] && a[i] == b[j] && b[i] == a[j]) {
                            result += 2;
                            flag = false;
                            break;
                        }

                if (flag) return -1;
                t[j] = true;
            }

        return result;
    }

}
