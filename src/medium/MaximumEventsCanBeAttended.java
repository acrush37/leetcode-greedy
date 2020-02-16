package medium;

import java.util.Arrays;

/*
    Given an array of events where events[i] = [startDayi, endDayi].
    Every event i starts at startDayi and ends at endDayi.

    You can attend an event i at any day d where startTimei <= d <= endTimei.
    Notice that you can only attend one event at any time d.

    Return the maximum number of events you can attend.
 */
public class MaximumEventsCanBeAttended {

    public static void main(String... args) {

        int[][] events = {{1, 2}, {2, 3}, {3, 4}};
        MaximumEventsCanBeAttended maximumEventsCanBeAttended = new MaximumEventsCanBeAttended();
        System.out.println(maximumEventsCanBeAttended.maxEvents(events));
    }

    public int maxEvents(int[][] events) {

        int result = 0;
        Arrays.sort(events, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        boolean[] t = new boolean[1+events[events.length-1][1]];

        for (int[] x : events)
            for (int i = x[0]; i <= x[1]; i++)
                if (t[i] == false) {
                    t[i] = true;
                    result++;
                    break;
                }

        return result;
    }

}
