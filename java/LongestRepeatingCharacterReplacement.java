public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int ans = 0, max = 0, slow = 0;
        int[] counts = new int[128];
        for (int fast = 0; fast < s.length(); fast++) {
            max = Math.max(max, ++counts[s.charAt(fast)]);
            while (fast - slow + 1 - max > k) {
                counts[s.charAt(slow)]--;
                slow++;
            }
            ans = Math.max(ans, fast - slow + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;

        System.out.printf("s = %s\n", s);
        System.out.printf("k = %d\n", k);
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        System.out.println(solution.characterReplacement(s, k));
    }
}