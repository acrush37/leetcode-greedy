package hard;

/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.
 */
public class JumpGameII {

    public static void main(String... args) {

        int[] nums = {2, 3, 1, 1, 4};
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(nums));
    }

    public int jump(int[] nums) {

        int n = nums.length;
        Integer[] f = new Integer[n];
        int p = 0;
        while (p < n-1 && nums[p] > nums[p+1]) p++;
        int x = Math.min(n-1, nums[0]);
        for (int i = p; i <= x; i++) f[i] = 1;
        f[0] = 0;

        for (int i = p; i < n; i++) {

            x = Math.min(n-1, i + nums[i]);

            for (int j = i+1; j <= x; j++)
                if (f[j] == null) f[j] = 1 + f[i];
                else f[j] = Math.min(f[j], 1 + f[i]);
        }

        return f[n-1];
    }

}
