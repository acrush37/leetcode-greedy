package hard;

/*
    There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
    (i.e The length of the garden is n). There are n + 1 taps located at points [0, 1, ..., n] in the garden.

    Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed)
    means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.

    Return the minimum number of taps that should be open to water the whole garden,
    If the garden cannot be watered return -1.
 */
public class MinimumTapsOpenWaterGarden {

    public static void main(String... args) {

        int[] ranges = {3, 4, 1, 1, 0, 0};
        MinimumTapsOpenWaterGarden minimumTapsOpenWaterGarden = new MinimumTapsOpenWaterGarden();
        System.out.println(minimumTapsOpenWaterGarden.minTaps(5, ranges));
    }

    public int minTaps(int n, int[] ranges) {

        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) f[i] = n+1;

        for (int i = 0; i <= n; i++) {
            int l = Math.max(i - ranges[i], 0), r = Math.min(i + ranges[i], n);
            for (int j = l+1; j <= r; j++) f[j] = Math.min(f[j], f[l] + 1);
        }

        return f[n] == n+1 ? -1 : f[n];
    }

}
