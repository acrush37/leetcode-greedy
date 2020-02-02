package hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once.

    You must make sure your result is the smallest in lexicographical order among all possible results.
 */
public class RemoveDuplicateLetters {

    public static void main(String... args) {

        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(""));
    }

    public String removeDuplicateLetters(String s) {

        if (s.isEmpty()) return "";
        int n = s.length(), k = 0;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> t = new HashMap<>();
        for (int i = 0; i < n; i++) t.put(s.charAt(i), i);

        while (true) {

            int x = n, p = 0;
            char c = 'z' + 1;
            Iterator<Integer> it = t.values().iterator();
            while (it.hasNext()) x = Math.min(x, it.next());

            for (int i = k; i <= x; i++) {

                char ch = s.charAt(i);

                if (ch < c && t.containsKey(ch)) {
                    p = i;
                    c = ch;
                }
            }

            k = p+1;
            t.remove(c);
            sb.append(c);
            if (t.isEmpty()) return sb.toString();
        }
    }

}
