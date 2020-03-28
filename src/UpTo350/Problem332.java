package UpTo350;

import java.util.*;

public class Problem332 {
    Map<String, Queue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket :
                tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>(Comparator.naturalOrder()));
            map.get(ticket.get(0)).add(ticket.get(1));
            dfs("JFK");
        }
        return ans;
    }

    private void dfs(String node) {
        Queue<String> q = map.get(node);
        while (!q.isEmpty()) dfs(q.poll());
        ans.add(0, node);
    }
}
