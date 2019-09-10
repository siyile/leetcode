import java.util.TreeMap;

public class Problem911 {
    private class TopVotedCandidate {
        // TreeMap<Time, Person>
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            int n = persons.length;
            int[] cnt = new int[n];
            int top = 0, candidate = -1;
            for (int i = 0; i < n; i++) {
                int person = persons[i];
                if (++cnt[person] >= top) {
                    top = cnt[person];
                    candidate = person;
                    map.put(times[i], candidate);
                }
            }
        }

        public int q(int t) {
            return map.floorEntry(t).getValue();
        }
    }
}
