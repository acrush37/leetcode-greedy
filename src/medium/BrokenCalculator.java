package medium;

/*
    On a broken calculator that has a number showing on its display, we can perform two operations:

    Double: Multiply the number on the display by 2, or;
    Decrement: Subtract 1 from the number on the display.
    Initially, the calculator is displaying the number X.

    Return the minimum number of operations needed to display the number Y.
 */
public class BrokenCalculator {

    public static void main(String... args) {

        BrokenCalculator brokenCalculator = new BrokenCalculator();
        System.out.println(brokenCalculator.brokenCalc(1024, 1));
    }

    public int brokenCalc(int X, int Y) {

        int count = 0;

        while (X < Y) {
            count++;
            Y = ((Y & 1) == 0) ? Y >> 1 : 1 + Y;
        }

        return count + X - Y;
    }

}
