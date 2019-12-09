package easy;

import java.util.Arrays;
import java.util.List;

/*
    There are 2N people a company is planning to interview.
    The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

    Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 */
public class TwoCityScheduling {

    public static void main(String... args) {

        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        System.out.println(twoCityScheduling.twoCitySchedCost(costs));
    }

    public int twoCitySchedCost(int[][] costs) {

        int result = 0;
        int n = costs.length;
        int m = n >> 1;
        List<int[]> f = Arrays.asList(costs);
        f.sort((x, y) -> x[0] + y[1] - y[0] - x[1]);
        for (int i = 0; i < n; i++) result += i < m ? costs[i][0] : costs[i][1];
        return result;
    }

}
