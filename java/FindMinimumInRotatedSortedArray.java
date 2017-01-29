import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        System.out.println(Arrays.toString(nums));

        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();
        System.out.println(solution.findMin(nums));
    }
}