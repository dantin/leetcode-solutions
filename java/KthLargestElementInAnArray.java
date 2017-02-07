import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int low, int high) {
        int pivot = nums[high];

        int left = low;
        int right = high;

        while (true) {
            while (nums[left] < pivot && left < right) left++;
            while (nums[right] >= pivot && right > left) right--;
            if (left == right) break;
            swap(nums, left, right);
        }
        swap(nums, left, high);

        if (left + 1 == k)
            return pivot;
        else if (k < left + 1)
            return quickSelect(nums, k, low, left - 1);
        else
            return quickSelect(nums, k, left + 1, high);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : nums) {
            heap.offer(x);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(Arrays.toString(nums));
        System.out.println(k);

        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        System.out.println(solution.findKthLargest(nums, k));
    }
}