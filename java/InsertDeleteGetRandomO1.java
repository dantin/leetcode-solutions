import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

    public static void main(String[] args) {
        int val = 1;

        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(val);
        boolean param_2 = obj.remove(val);
        int param_3 = obj.getRandom();
    }
}

class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> nums;
    private Random random;
    private int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
        this.size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, size);
        if (size == nums.size()) {
            nums.add(val);
        } else {
            nums.set(size, val);
        }
        size++;

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.isEmpty() || !map.containsKey(val)) return false;

        int idx = map.get(val);
        int last = nums.get(--size);
        nums.set(idx, last);
        map.put(last, idx);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(size);
        return nums.get(idx);
    }
}