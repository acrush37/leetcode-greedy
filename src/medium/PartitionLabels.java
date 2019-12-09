package medium;

import java.util.ArrayList;
import java.util.List;

/*
    A string S of lowercase letters is given. We want to partition this string
    into as many parts as possible so that each letter appears in at most one
    part, and return a list of integers representing the size of these parts.
 */
public class PartitionLabels {

    public static void main(String... args) {

        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();
        int[] f = new int[123];
        char[] c = S.toCharArray();
        int n = c.length;
        int p = 0;
        for (int i = 1; i < n; i++) f[c[i]] = i;

        while (p < n) {

            if (p == f[c[p]]) {
                p++;
                result.add(1);
            } else {
                int x = p;
                int max = f[c[p]];
                while (p++ < max) max = Math.max(max, f[c[p]]);
                result.add(max - x + 1);
            }
        }

        return result;
    }

}
