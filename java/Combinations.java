import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> out = new LinkedList<>();
        dfs(n, k, ans, out, 1);
        return ans;
    }

    private void dfs(int n, int k, List<List<Integer>> ans, LinkedList<Integer> out, int start) {
        if (out.size() == k) {
            ans.add(new LinkedList<Integer>(out));
        } else {
            for (int i = start; i <= n; i++) {
                out.offerLast(i);
                dfs(n, k, ans, out, i + 1);
                out.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.printf("n = %d, k = %d\n", n, k);

        Combinations solution = new Combinations();
        solution.combine(n, k).forEach(System.out::println);
    }
}