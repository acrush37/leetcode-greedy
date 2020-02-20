package hard;

/*
    Given an array of integers target.
    From a starting array, A consisting of all 1's, you may perform the following procedure :

    let x be the sum of all elements currently in your array.
    choose index i, such that 0 <= i < target.size and set the value of A at index i to x.

    You may repeat this procedure as many times as needed.
    Return True if it is possible to construct the target array from A otherwise return False.
 */
public class ConstructTargetArrayMultipleSums {

    public static void main(String... args) {

        int[] target = {1, 1000000000};
        ConstructTargetArrayMultipleSums constructTargetArrayMultipleSums = new ConstructTargetArrayMultipleSums();
        System.out.println(constructTargetArrayMultipleSums.isPossible(target));
    }

    public boolean isPossible(int[] target) {

        int p = 0;
        long s = 0;

        for (int i = 0; i < target.length; i++) {
            s += target[i];
            if (target[i] > target[p]) p = i;
        }

        if (target[p] == 1) return true;
        if ((s -= target[p]) == 0) return false;
        int t = target[p];
        if ((target[p] %= s) == 0) target[p] = (int) s;
        if (target[p] == t) return false;
        return isPossible(target);
    }

}
