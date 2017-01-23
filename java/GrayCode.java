import java.util.List;
import java.util.LinkedList;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = null;
        if (n == 0) {
            ans = new LinkedList<>();
            ans.add(0);
            return ans;
        }

        ans = grayCode(n - 1);
        int weight = 1 << (n - 1);
        int size = ans.size();

        for (int i = size - 1; i >= 0; i--) {
            ans.add(weight + ans.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.printf("n = %d\n", n);

        GrayCode solution = new GrayCode();
        System.out.printf("%s\n", solution.grayCode(n));
    }
}