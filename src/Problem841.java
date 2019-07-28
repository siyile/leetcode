import java.util.List;

public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(visited, rooms, 0);

        for (boolean x :
                visited) {
            if (!x) return false;
        }
        return true;
    }

    private void dfs(boolean[] visited, List<List<Integer>> rooms, int pos) {
        for (Integer room :
                rooms.get(pos)) {
            if (!visited[room]) {
                visited[room] = true;
                dfs(visited, rooms, room);
            }
        }
    }
}
