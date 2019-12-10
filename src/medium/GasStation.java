package medium;

import java.util.ArrayList;
import java.util.List;

/*
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 */
public class GasStation {

    public static void main(String... args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int s = 0, n = gas.length;
        List<Integer> t = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s += (gas[i] -= cost[i]);
            if (gas[i] >= 0) t.add(i);
        }

        if (s < 0) return -1;

        for (int p : t) {

            s = 0;
            boolean flag = true;

            for (int i = 0; i < n; i++) {

                int j = (p + i) % n;

                if ((s += gas[j]) < 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) return p;
        }

        return 0;
    }

}
