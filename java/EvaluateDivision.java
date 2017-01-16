import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans = new double[queries.length];
        // filter unexcepted words
        Set<String> set = new HashSet<>();
        for (String[] equation : equations) {
            set.add(equation[0]);
            set.add(equation[1]);
        }

        for (int i = 0; i < queries.length; i++) {
            String[] tokens = queries[i];
            if (!set.contains(tokens[0]) || !set.contains(tokens[1])) {
                ans[i] = -1D;
            } else {
                Deque<Integer> stack = new LinkedList<>();
                ans[i] = evaluate(equations, values, tokens, stack);
            }

        }

        return ans;
    }

    private double evaluate(String[][] equations, double[] values, String[] tokens, Deque<Integer> stack) {
        // directly lookup
        for (int i = 0; i < equations.length; i++) {
            if (equations[i][0].equals(tokens[0]) && equations[i][1].equals(tokens[1])) return values[i];
            if (equations[i][0].equals(tokens[1]) && equations[i][1].equals(tokens[0])) return 1 / values[i];
        }
        // indirectly lookup
        for (int i = 0; i < equations.length; i++) {
            if (!stack.contains(i) && tokens[0].equals(equations[i][0])) {
                stack.push(i);
                double temp = values[i] * evaluate(equations, values, new String[] {equations[i][1], tokens[1]}, stack);
                if (temp > 0) {
                    return temp;
                } else {
                    stack.pop();
                }
            }
            if (!stack.contains(i) && tokens[0].equals(equations[i][1])) {
                stack.push(i);
                double temp = evaluate(equations, values, new String[] {equations[i][0], tokens[1]}, stack) / values[i];
                if (temp > 0) {
                    return temp;
                } else {
                    stack.pop();
                }
            }
        }
        return -1D;
    }

    public static void main(String[] args) {
        String[][] equations = new String[][] {new String[]{"a", "b"}, new String[]{"b", "c"}};
        double[] values = new double[] {2.0, 3.0};
        String[][] queries = new String[][] {new String[]{"a", "c"}, new String[]{"b", "a"}, new String[]{"a", "e"}, new String[]{"a", "a"}, new String[]{"x", "x"}};
        System.out.printf("equations = %s\n", toString(equations));
        System.out.printf("values = %s\n", Arrays.toString(values));
        System.out.printf("queries = %s\n", toString(queries));

        EvaluateDivision solution = new EvaluateDivision();
        System.out.printf("results = %s\n", Arrays.toString(solution.calcEquation(equations, values, queries)));
    }

    private static String toString(String[][] equations) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < equations.length; i++) {
            if (i != 0) buffer.append(", ");
            buffer.append(String.format("[\"%s\", \"%s\"]", equations[i][0], equations[i][1]));
        }
        buffer.append("]");
        return buffer.toString();
    }
}