import java.util.*;

public class Problem332 {
    Map<String, Queue<String>> graph = new HashMap<>();
    List<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket :
                tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>(Comparator.naturalOrder()));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");
        return ans;
    }

    private void dfs(String departure) {
        Queue<String> destinations = graph.get(departure);
        while (destinations != null && !destinations.isEmpty())
            dfs(destinations.poll());
        ans.add(0, departure);
    }
}
