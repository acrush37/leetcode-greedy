package easy;

/*
    At a lemonade stand, each lemonade costs $5.

    Customers are standing in a queue to buy from you, and order one at a time
    (in the order specified by bills).

    Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
    You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

    Note that you don't have any change in hand at first.
    Return true if and only if you can provide every customer with correct change.
 */
public class LemonadeChange {

    public static void main(String... args) {

        int[] bills = {5, 5, 5, 10, 20};
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for (int x : bills)
            if (x == 5) five++;
            else if (x == 10) {
                if (five-- == 0) return false;
                ten++;
            } else {
                if (ten == 0) {
                    if ((five -= 3) < 0) return false;
                } else {
                    ten--;
                    if (five-- == 0) return false;
                }
            }

        return true;
    }

}
