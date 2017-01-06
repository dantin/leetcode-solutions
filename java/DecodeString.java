import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {

    public String decodeString(String s) {
        StringBuilder tmp = new StringBuilder();

        Deque<Integer> digits = new LinkedList<>();
        Deque<StringBuilder> tokens = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                cnt *= 10;
                cnt += ch - '0';
            } else if (ch == '[') {
                digits.push(cnt);
                tokens.push(new StringBuilder(tmp));
                cnt = 0;
                tmp.setLength(0);
            } else if (ch == ']') {
                int k = digits.pop();
                while (k-- > 0) {
                    tokens.peek().append(tmp);
                }
                tmp = tokens.pop();
            } else {
                tmp.append(ch);
            }
        }

        return tokens.isEmpty() ? tmp.toString() : tokens.pop().toString();
    }

    public static void main(String[] args) {
        // String s = "3[a]2[bc]";
        // String s = "3[a2[c]]";
        String s = "2[abc]3[cd]ef";

        System.out.printf("Input: %s\n", s);
        DecodeString solution = new DecodeString();
        System.out.printf("%s\n", solution.decodeString(s));
    }

}