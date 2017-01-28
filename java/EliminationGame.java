public class EliminationGame {

    public int lastRemaining(int n) {
        int base = 1, ans = 1;
        while (base * 2 <= n) {
            ans += base;
            base *= 2;
            if (base * 2 > n) break;
            if ((n / base) % 2 == 1) ans += base;
            base *= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(n);

        EliminationGame solution = new EliminationGame();
        System.out.println(solution.lastRemaining(n));
    }
}