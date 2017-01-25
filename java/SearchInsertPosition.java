import java.util.Arrays;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
        int target = 7;
        System.out.printf("nums = %s\n", Arrays.toString(nums));
        System.out.printf("target = %d\n", target);

        SearchInsertPosition solution = new SearchInsertPosition();
        System.out.println(solution.searchInsert(nums, target));
    }
}