import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            buffer.setLength(0);
            if (i % 3 == 0) {
                buffer.append("Fizz");
            }
            if (i % 5 == 0) {
                buffer.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                buffer.append(i);
            }
            list.add(buffer.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        FizzBuzz solution = new FizzBuzz();
        solution.fizzBuzz(15).forEach(System.out::println);
    }
}