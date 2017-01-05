import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(nums));

        Permutations solution = new Permutations();
        for(List<Integer> perm : solution.permute(nums)) {
            System.out.println(perm);
        }
    }
}