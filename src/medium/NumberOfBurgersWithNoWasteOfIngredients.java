package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given two integers tomatoSlices and cheeseSlices. The ingredients of different burgers are as follows:

    Jumbo Burger: 4 tomato slices and 1 cheese slice.
    Small Burger: 2 Tomato slices and 1 cheese slice.

    Return [total_jumbo, total_small] so that the number of remaining tomatoSlices equal to 0 and the number of remaining cheeseSlices equal to 0.
    If it is not possible to make the remaining tomatoSlices and cheeseSlices equal to 0 return [].
 */
public class NumberOfBurgersWithNoWasteOfIngredients {

    public static void main(String... args) {

        NumberOfBurgersWithNoWasteOfIngredients numberOfBurgersWithNoWasteOfIngredients = new NumberOfBurgersWithNoWasteOfIngredients();
        System.out.println(numberOfBurgersWithNoWasteOfIngredients.numOfBurgers(16, 7));
    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        if ((tomatoSlices & 1) == 1) return Collections.EMPTY_LIST;
        int x = (tomatoSlices >> 1) - cheeseSlices;
        int y = cheeseSlices - x;
        return x < 0 || y < 0 ? Collections.EMPTY_LIST : Arrays.asList(x, y);
    }
}
