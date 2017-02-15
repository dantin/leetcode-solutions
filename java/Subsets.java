import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max <<= 1;
        }
        for (int i = 0; i < max; i++) {
            ans.add(num2set(nums, i));
        }
        return ans;
    }

    private List<Integer> num2set(int[] nums, int num) {
        List<Integer> set = new ArrayList<>();
        int i = 0;
        while (num > 0) {
            if ((num & 1) == 1) set.add(nums[i]);
            num >>>= 1;
            i++;
        }
        return set;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) return ans;

        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int n = ans.size();
            for (int j = 0; j < n; j++) {
                List<Integer> subset = new ArrayList<Integer>(ans.get(j));
                subset.add(nums[i]);
                ans.add(new ArrayList<Integer>(subset));
            }
        }

        return ans;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) return ans;

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