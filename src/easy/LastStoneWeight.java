package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    We have a collection of rocks, each rock has a positive integer weight.
    Each turn, we choose the two heaviest rocks and smash them together.
    Suppose the stones have weights x and y with x <= y.  The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
    At the end, there is at most 1 stone left.
    Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight {

    public static void main(String... args) {

        int[] stones = {2,7, 4, 1, 8, 1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : stones) q.add(x);

        while (q.size() > 1) {

            int x = q.poll();
            int y = q.poll();
            if (x != y) q.offer(x-y);
        }

        return q.isEmpty() ? 0 : q.peek();
    }

}
