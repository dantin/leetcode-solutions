import java.util.Arrays;

public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        if (nums == null || nums.length == 0) return sum;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 3, 2};

        ArrayPartitionI solution = new ArrayPartitionI();
        System.out.println(solution.arrayPairSum(nums));
    }
}