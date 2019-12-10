package medium;

/*
    Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains
    information about the i-th trip: the number of passengers that must be picked up, and the
    locations to pick them up and drop them off.

    The locations are given as the number of kilometers due east from your vehicle's initial location.

    Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 */
public class CarPooling {

    public static void main(String... args) {

        int[][] trips = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(trips, 11));
    }

    public boolean carPooling(int[][] trips, int capacity) {

        int n = trips.length;
        int[][] f = new int[1001][1001];

        for (int i = 0; i < n; i++)
            for (int j = trips[i][1]; j < trips[i][2]; j++)
                f[j][++f[j][0]] = i;

        for (int i = 0; i <= 1000; i++) {

            int s = 0;

            for (int j = 1; j <= f[i][0]; j++)
                if ((s += trips[f[i][j]][0]) > capacity)
                    return false;
        }

        return true;
    }

}
