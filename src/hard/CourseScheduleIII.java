package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    There are n different online courses numbered from 1 to n.
    Each course has some duration(course length) t and closed on dth day.

    A course should be taken continuously for t days and must be finished before or on the dth day.
    You will start at the 1st day.

    Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 */
public class CourseScheduleIII {

    public static void main(String... args) {

        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        CourseScheduleIII courseScheduleIII = new CourseScheduleIII();
        System.out.println(courseScheduleIII.scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {

        int s = 0;
        Arrays.sort(courses, Comparator.comparingInt(x -> x[1]));
        PriorityQueue<Integer> q = new PriorityQueue< >((x, y) -> y - x);

        for (int[] c: courses) {
            if (s + c[0] <= c[1]) {
                s += c[0];
                q.offer(c[0]);
            } else if (!q.isEmpty() && q.peek() > c[0]) {
                s += c[0] - q.poll();
                q.offer(c[0]);
            }
        }

        return q.size();
    }

}
