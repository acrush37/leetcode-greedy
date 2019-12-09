package easy;

import java.util.Arrays;

/*
    Assume you are an awesome parent and want to give your children some cookies.
    But, you should give each child at most one cookie.
    Each child i has a greed factor gi, which is the minimum size of a cookie that
    the child will be content with; and each cookie j has a size sj.

    If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
    Your goal is to maximize the number of your content children and output the maximum number.
 */
public class AssignCookies {

    public static void main(String... args) {

        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        AssignCookies assignCookies = new AssignCookies();
        System.out.println(assignCookies.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {

        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        int p = 0;

        for (int i = 0; i < m; i++) {
            while (p < n && s[p] < g[i]) p++;
            if (p++ == n) break;
            result++;
        }


        return result;
    }

}
