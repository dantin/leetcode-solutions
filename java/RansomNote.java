import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cache = new int[255];
        for (char c : magazine.toCharArray()) {
            cache[c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (cache[c] > 0) {
                cache[c]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();
        System.out.println(solution.canConstruct("aa", "aab"));
    }
}