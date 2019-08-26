import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(visited, rooms, 0);

        return visited.size() == rooms.size();
    }

    private void dfs(Set<Integer> visited, List<List<Integer>> rooms, int room) {
        for (int key :
                rooms.get(room)) {
            if (!visited.contains(key)) {
                visited.add(key);
                dfs(visited, rooms, key);
            }
        }
    }
}
