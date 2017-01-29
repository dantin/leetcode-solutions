import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin1(int[] nums) {
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