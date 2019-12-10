package medium;

import java.util.Arrays;

/*
    An arrow can be shot up exactly vertically from different points along the x-axis.
    A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
    There is no limit to the number of arrows that can be shot.
    An arrow once shot keeps travelling up infinitely.
    The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String... args) {

        int[][] points = {{9,12}, {1,10}, {4,11}, {8,12}, {3,9}, {6,9}, {6,7}};
        MinimumNumberOfArrowsToBurstBalloons minimumNumberOfArrowsToBurstBalloons = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(minimumNumberOfArrowsToBurstBalloons.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {

        int n = points.length;
        if (n <= 1) return n;
        Arrays.sort(points, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
        int result = 1, i = 1, p = points[0][1];

        while (i < n) {

            int j = 0;
            while (j < n && points[j][0] <= p) j++;
            if (j == n) return result;
            p = points[i = j][1];
            result++;
        }

        return result;
    }

}
