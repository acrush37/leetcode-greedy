package hard;

import java.util.Arrays;

/*
    An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.

    Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2.
 */
public class SetIntersectionAtLeastTwo {

    public static void main(String... args) {

        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        SetIntersectionAtLeastTwo setIntersectionAtLeastTwo = new SetIntersectionAtLeastTwo();
        System.out.println(setIntersectionAtLeastTwo.intersectionSizeTwo(intervals));
    }

    public int intersectionSizeTwo(int[][] intervals) {

        int result = 0, x = -1, y = -1;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] <= x) continue;

            if (intervals[i][0] > y) {
                result += 2;
                y = intervals[i][1];
                x = y-1;
            } else {
                result++;
                x = y;
                y = intervals[i][1];
            }
        }

        return result;
    }

}
