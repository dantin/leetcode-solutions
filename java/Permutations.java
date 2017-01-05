import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        permute(nums, 0, ans);
        return ans;
    }

    private void permute(int[] nums, int n, List<List<Integer>> ans) {
        if (n == nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums, i, n);
            permute(nums, n + 1, ans);
            swap(nums, i, n);
        }
    }

    private void swap(int[] nums, int to, int from) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums));

        Permutations solution = new Permutations();
        for (List<Integer> perm : solution.permute(nums)) {
            System.out.println(perm);
        }
    }
}