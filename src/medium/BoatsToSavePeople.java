package medium;

import java.util.Arrays;

/*
    The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

    Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

    Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
 */
public class BoatsToSavePeople {

    public static void main(String... args) {

        int[] people = {3, 2, 2, 1};
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        System.out.println(boatsToSavePeople.numRescueBoats(people, 3));
    }

    public int numRescueBoats(int[] people, int limit) {

        int result = 0;
        int n = people.length;
        Arrays.sort(people);
        boolean[] t = new boolean[n];

        for (int i = 0; i < n; i++)
            if (!t[i]) {

                result++;
                int x = limit - people[i];
                if (i != n-1 && people[i+1] > x) continue;

                for (int j = n-1; j > i; j--)
                    if (!t[j] && people[j] <= x) {
                        t[j] = true;
                        break;
                    }
            }

        return result;
    }

}
