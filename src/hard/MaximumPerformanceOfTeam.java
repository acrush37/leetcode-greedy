package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    There are n engineers numbered from 1 to n and two arrays: speed and efficiency, where speed[i]
    and efficiency[i] represent the speed and efficiency for the i-th engineer respectively.

    Return the maximum performance of a team composed of at most k engineers, since the answer
    can be a huge number, return this modulo 10^9 + 7. The performance of a team is the sum of
    their engineers' speeds multiplied by the minimum efficiency among their engineers.
 */
public class MaximumPerformanceOfTeam {

    public static void main(String... args) {

        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        MaximumPerformanceOfTeam maximumPerformanceOfTeam = new MaximumPerformanceOfTeam();
        System.out.println(maximumPerformanceOfTeam.maxPerformance(6, speed, efficiency, 2));
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] f = new int[n][2];
        long result = 0, s = 0, p = 1000000007;
        for (int i = 0; i < n; i++) f[i] = new int[]{speed[i], efficiency[i]};
        Arrays.sort(f, Comparator.comparingInt(x -> -x[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int[] x : f) {

            s += x[0];
            q.add(x[0]);
            if (q.size() > k) s -= q.poll();
            result = Math.max(result, s * x[1]);
        }

        return (int)(result % p);
    }

}
