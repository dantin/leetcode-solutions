import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(Interval[] intervals) {
        int ans = 0, len = intervals.length, last = 0;
        Arrays.sort(intervals, 0, len, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < len; i++) {
            if (intervals[i].start < intervals[last].end) {
                ans++;
                if (intervals[i].end < intervals[last].end) last = i;
            } else {
                last = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] {
            new Interval(1, 2), new Interval(2, 3),
            new Interval(3, 4), new Interval(1, 3)
        };
        System.out.println(Arrays.toString(intervals));

        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("[");
        buf.append(start).append(", ").append(end).append("]");
        return buf.toString();
    }
}