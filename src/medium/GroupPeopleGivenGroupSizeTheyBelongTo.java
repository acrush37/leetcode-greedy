package medium;

import java.util.ArrayList;
import java.util.List;

/*
    There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group.
    Given the array groupSizes of length n telling the group size each person belongs to,
    return the groups there are and the people's IDs each group includes.

    You can return any solution in any order and the same applies for IDs.
    Also, it is guaranteed that there exists at least one solution.
 */
public class GroupPeopleGivenGroupSizeTheyBelongTo {

    public static void main(String... args) {

        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        GroupPeopleGivenGroupSizeTheyBelongTo groupPeopleGivenGroupSizeTheyBelongTo = new GroupPeopleGivenGroupSizeTheyBelongTo();
        System.out.println(groupPeopleGivenGroupSizeTheyBelongTo.groupThePeople(groupSizes));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();
        int n = groupSizes.length;
        int[][] f = new int[n+1][n+1];
        for (int i = 0; i < n; i++) f[groupSizes[i]][++f[groupSizes[i]][0]] = i;
        List<Integer> t = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            if (f[i][0] != 0)
                for (int j = 1; j <= f[i][0]; j++) {

                    t.add(f[i][j]);

                    if (j % i == 0) {
                        result.add(t);
                        t = new ArrayList<>();
                    }
                }

        return result;
    }

}
