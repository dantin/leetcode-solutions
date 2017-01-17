import java.util.Arrays;
import java.util.Random;

public class RandomPickIndex {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 3, 3};
        System.out.println(Arrays.toString(nums));

        Solution solution = new Solution(nums);
        System.out.println(solution.pick(3));
    }
}

class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int cnt = 0, index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            cnt++;
            if (random.nextInt(cnt) == 0) index = i;
        }
        return index;
    }
}