package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given two integers A and B, return any string S such that:

    S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
    The substring 'aaa' does not occur in S;
    The substring 'bbb' does not occur in S.
 */
public class StringWithoutAAAOrBBB {

    public static void main(String... args) {

        StringWithoutAAAOrBBB stringWithoutAAAOrBBB = new StringWithoutAAAOrBBB();
        System.out.println(stringWithoutAAAOrBBB.strWithout3a3b(3,3));
    }

    public String strWithout3a3b(int A, int B) {

        String result = "";
        if (A == 0 && B == 0) return result;
        List<Character> t = new ArrayList<>();

        if (A > B) {

            int n = (A-1) >> 1;

            for (int i = 0; i < n; i++) {
                t.add('a');
                t.add('a');
                t.add('b');
            }

            B -= n;
            A -= n << 1;
            for (int i = 0; i < A; i++) t.add('a');
            if (B-- >= 1) t.add('b');
            if (B-- >= 1) t.add(0, 'b');
            if (B-- >= 1) t.add(0, 'b');

            for (int i = 0; i < B; i++)
                for (int j = 1; j < t.size(); j++)
                    if (t.get(j) == 'a' && t.get(j-1) == 'a') {
                        t.add(j, 'b');
                        break;
                    }
        } else {

            int n = (B-1) >> 1;

            for (int i = 0; i < n; i++) {
                t.add('b');
                t.add('b');
                t.add('a');
            }

            A -= n;
            B -= n << 1;
            for (int i = 0; i < B; i++) t.add('b');
            if (A-- >= 1) t.add('a');
            if (A-- >= 1) t.add(0, 'a');
            if (A-- >= 1) t.add(0, 'a');

            for (int i = 0; i < A; i++)
                for (int j = 1; j < t.size(); j++)
                    if (t.get(j) == 'b' && t.get(j-1) == 'b') {
                        t.add(j, 'a');
                        break;
                    }
        }

        for (char c : t) result += c;
        return result;
    }

}
