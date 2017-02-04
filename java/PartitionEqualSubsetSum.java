import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false;
        sum /= 2;

        int[][] dp = new int[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    // 前0个数，所以价值均为0；
                    dp[i][j] = 0;
                } else if (j < nums[i - 1]) {
                    // 在装第i-1个数时，先判断剩余容量j是否大于nums[i-1]
                    // 空间不够，所以维持不变
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //空间够，就通过比较大小来判断是否该放入第i-1个数
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return dp[nums.length][sum] == sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 5, 11, 5};
        System.out.println(Arrays.toString(nums));

        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        System.out.println(solution.canPartition(nums));
    }
}