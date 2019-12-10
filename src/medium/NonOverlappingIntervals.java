package medium;

import java.util.Arrays;

/*
    Given a collection of intervals, find the minimum number of intervals you
    need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {

    public static void main(String... args) {

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1) return 0;
        Arrays.sort(intervals, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
        int result = 0, i = 0, p = intervals[0][1];

        while (i < n) {

            int j = i+1;
            while (j < n && intervals[j][0] < p) j++;
            result += j - i - 1;
            if (j == n) return result;
            p = intervals[i = j][1];
        }

        return result;
    }

}
