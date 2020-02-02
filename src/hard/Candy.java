package hard;

/*
    There are N children standing in a line. Each child is assigned a rating value.
    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

    What is the minimum candies you must give?
 */
public class Candy {

    public static void main(String... args) {

        int[] ratings = {1, 2, 3, 1, 0};
        Candy candy = new Candy();
        System.out.println(candy.candy(ratings));
    }

    public int candy(int[] ratings) {

        int result = 0;
        int n = ratings.length;
        int[] a = new int[n];
        a[0] = 1;

        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i-1]) a[i] = a[i-1] + 1;
            else if (ratings[i] == ratings[i-1] || a[i-1] != 1) a[i] = 1;
            else {
                a[i] = 1;
                int j = i-1;
                while (j >= 0 && ratings[j] > ratings[j+1] && a[j] <= a[j+1]) a[j--]++;
            }

        for (int x : a) result += x;
        return result;
    }

}
