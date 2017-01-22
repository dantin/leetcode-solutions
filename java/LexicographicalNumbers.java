import java.util.LinkedList;
import java.util.List;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new LinkedList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            ans.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                if (cur >= n) cur /= 10;
                cur += 1;
                while (cur % 10 == 0) cur /= 10;
            }
        }
        return ans;
    }

    public List<Integer> lexicalOrder1(int n) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            lexial(i, n, ans);
        }
        return ans;
    }

    private void lexial(int cur, int n, List<Integer> ans) {
        if (cur > n) return;
        ans.add(cur);
        for (int i = 0; i < 10; i++) {
            int num = cur * 10 + i;
            if (num > n) break;
            lexial(num, n, ans);
        }
    }

    public static void main(String[] args) {
        int n = 13;
        LexicographicalNumbers solution = new LexicographicalNumbers();

        System.out.printf("n = %d\n", n);
        System.out.printf("%s\n", solution.lexicalOrder(n));
    }
}