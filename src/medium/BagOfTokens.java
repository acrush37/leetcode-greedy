package medium;

import java.util.Arrays;

/*
    You have an initial power P, an initial score of 0 points, and a bag of tokens.
    Each token can be used at most once, has a value token[i], and has potentially two ways to use it.

    If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
    If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.

    Return the largest number of points we can have after playing any number of tokens.
 */
public class BagOfTokens {

    public static void main(String... args) {

        int[] tokens = {100, 200, 300, 400};
        BagOfTokens bagOfTokens = new BagOfTokens();
        System.out.println(bagOfTokens.bagOfTokensScore(tokens, 200));
    }

    public int bagOfTokensScore(int[] tokens, int P) {

        int result = 0, points = 0, l = 0, r = tokens.length - 1;
        Arrays.sort(tokens);

        while (l <= r) {

            if (points <= 0 && P < tokens[l]) break;

            while (l <= r && P >= tokens[l]) {
                P -= tokens[l++];
                points++;
            }

            result = Math.max(result, points);

            if (l <= r && points > 0) {
                points--;
                P += tokens[r--];
            }
        }

        return result;
    }

}
