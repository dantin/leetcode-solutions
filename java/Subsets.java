import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) return ans;

        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, ans);

        return ans;
    }

    private void dfs(int[] nums, int from, List<Integer> path, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<Integer>(path));
        for (int i = from; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, subsets);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(nums));

        Subsets solution = new Subsets();
        solution.subsets(nums).forEach(System.out::println);
    }
}