import java.util.Arrays;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int x : nums) {
            if (min1 >= x) min1 = x;
            else if (min2 >= x) min2 = x;
            else return true;
        }

        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(nums));

        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        System.out.println(solution.increasingTriplet(nums));
    }
}