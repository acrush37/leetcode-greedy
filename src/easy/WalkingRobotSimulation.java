package easy;

import java.util.HashSet;
import java.util.Set;

/*
    A robot on an infinite grid starts at point (0, 0) and faces north.
    The robot can receive one of three possible types of commands:

    -2: turn left 90 degrees
    -1: turn right 90 degrees
    1 <= x <= 9: move forward x units
    Some of the grid squares are obstacles.

    The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

    If the robot would try to move onto them, the robot stays on the previous grid square instead
    (but still continues following the rest of the route.)

    Return the square of the maximum Euclidean distance that the robot will be from the origin.
 */
public class WalkingRobotSimulation {

    public static void main(String... args) {

        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation();
        System.out.println(walkingRobotSimulation.robotSim(commands, obstacles));
    }

    public int robotSim(int[] commands, int[][] obstacles) {

        int[] a = {0, 1, 0, -1};
        int[] b = {1, 0, -1, 0};
        int result = 0, degree = 0, x = 0, y = 0;
        Set<String> t = new HashSet<>();
        for (int[] o : obstacles) t.add(o[0] + "," + o[1]);

        for (int command : commands)
            if (command == -2) degree = (degree + 3) % 4;
            else if (command == -1) degree = (degree + 1) % 4;
            else {

                for (int j = 1; j <= command; j++) {

                    x += a[degree];
                    y += b[degree];

                    if (t.contains(x + "," + y)) {

                        x -= a[degree];
                        y -= b[degree];
                        break;
                    } else result = Math.max(result, x*x + y*y);
                }
            }

        return result;
    }

}
