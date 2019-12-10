package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a non-negative integer num represented as a string, remove k digits
    from the number so that the new number is the smallest possible.
 */
public class RemoveKDigits {

    public static void main(String... args) {

        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {

        List<Character> t = new ArrayList<>();
        char[] ch = num.toCharArray();
        for (char c : ch) t.add(c);

        while (k-- > 0) {

            int i = 0;
            int n = t.size() - 1;
            while (i < n && t.get(i) <= t.get(i+1)) i++;
            t.remove(i);
            while (!t.isEmpty() && t.get(0) == '0') t.remove(0);
            if (t.size() <= k) return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : t) sb.append(c);
        return sb.toString();
    }

}
