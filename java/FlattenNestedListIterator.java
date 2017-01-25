import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class FlattenNestedListIterator {

    public static void main(String[] args) {

    }
}

class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger t = stack.pop();
        return t.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger t = stack.peek();
            if (t.isInteger()) return true;
            stack.pop();
            for (int i = t.getList().size() - 1; i >= 0; i--) {
                stack.push(t.getList().get(i));
            }
        }
        return false;
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}