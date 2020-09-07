package UpTo650;

import java.util.*;

public class Problem635 {
    class LogSystem {
        String min;
        String max;
        TreeMap<String, List<Integer>> logs;
        Map<String, Integer> map;

        public LogSystem() {
            min = "2000:01:01:00:00:00";
            max = "2017:12:31:23:59:59";
            logs = new TreeMap<>();
            map = new HashMap<>();
            map.put("Years", 0);
            map.put("Months", 5);
            map.put("Days", 8);
            map.put("Hours", 11);
            map.put("Minutes", 14);
        }

        public void put(int id, String timestamp) {
            logs.computeIfAbsent(timestamp, ignore -> new ArrayList<>());
            logs.get(timestamp).add(id);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            int index = map.get(gra);
            String upper = s.substring(0, index) + min.substring(index);
            String lower = s.substring(0, index) + max.substring(index);
            NavigableMap<String, List<Integer>> sublogs = logs.subMap(upper, true, lower, true);
            List<Integer> ans = new ArrayList<>();

            for (List<Integer> list :
                    sublogs.values()) {
                ans.addAll(list);
            }

            return ans;
        }
    }
}
