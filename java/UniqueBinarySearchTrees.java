public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(n);
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(n));
    }
}