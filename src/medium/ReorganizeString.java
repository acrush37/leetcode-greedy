package medium;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry;

/*
    Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

    If possible, output any possible result.  If not possible, return the empty string.
 */
public class ReorganizeString {

    public static void main(String... args) {

        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aaaaabbbcccddee"));
    }

    public String reorganizeString(String S) {

        Map<Character, Integer> m = new HashMap<>();
        char[] ch = S.toCharArray();

        for (char c : ch) {
            Integer x = m.get(c);
            m.put(c, x == null ? 1 : 1 + x);
        }

        List<Character> f = new ArrayList<>();
        List<Entry<Character, Integer>> t = m.entrySet().stream().
                sorted(Comparator.comparing(i -> -i.getValue())).collect(Collectors.toList());
        Entry<Character, Integer> entry = t.get(0);
        int value = entry.getValue();
        char key = entry.getKey();
        int n = t.size() - 1;
        for (int i = 0; i < value; i++) f.add(key);

        for (int i = 1; i <= n; i++) {

            entry = t.get(i);
            value = entry.getValue();
            key = entry.getKey();

            for (int j = 0; j < value; j++) {

                boolean flag = true;

                for (int k = 1; k < f.size(); k++)
                    if (f.get(k) == f.get(k-1)) {
                        flag = false;
                        f.add(k, key);
                        break;
                    }

                if (flag) {

                    if (f.get(0) != key) f.add(0, key);
                    else {

                        int x = f.size() - 1;

                        if (f.get(x) != key) f.add(key);
                        else {

                            flag = true;

                            for (int k = 1; k <= x; k++)
                                if (f.get(k) != key && f.get(k-1) != key) {

                                    f.add(k, key);
                                    flag = false;
                                    break;
                                }

                            if (flag) return "";
                        }
                    }
                }
            }
        }

        n = f.size() - 1;
        for (int i = 0; i < n; i++) if (f.get(i) == f.get(i+1)) return "";
        StringBuilder sb = new StringBuilder();
        for (char c : f) sb.append(c);
        return sb.toString();
    }

}
