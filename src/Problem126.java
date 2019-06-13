import java.util.*;

public class Problem126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) return ans;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> routes = new HashMap<>();

        // generate routes
        bfs(beginSet, endSet, routes, dict, false);


        // generate paths
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        generatePath(beginWord, endWord, routes, ans, path);
        return ans;
    }

    public boolean bfs(Set<String> beginSet, Set<String> endSet, Map<String, List<String>> routes,
                       Set<String> dict, boolean flip) {
        if (beginSet.isEmpty())
            return false;

        if (beginSet.size() > endSet.size())
            return bfs(endSet, beginSet, routes, dict, !flip);

        dict.removeAll(beginSet);
        dict.removeAll(endSet);

        Set<String> next = new HashSet<>();

        boolean done = false;

        for (String x :
                beginSet) {
            for (int i = 0; i < x.length(); i++) {
                char[] chs = x.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (chs[i] != ch) {
                        chs[i] = ch;
                        String word = String.valueOf(chs);

                        String prev = flip ? word : x;
                        String cur = flip ? x : word;

                        List<String> route;

                        if (endSet.contains(word)) {
                            route = routes.getOrDefault(prev, new ArrayList<>());
                            done = true;
                            route.add(cur);
                            routes.put(prev, route);
                        }


                        if (!done && dict.contains(word)) {
                            route = routes.getOrDefault(prev, new ArrayList<>());
                            route.add(cur);
                            next.add(word);
                            routes.put(prev, route);
                        }
                    }
                }
            }
        }

        return  done || bfs(endSet, next, routes, dict, !flip);
    }

    public void generatePath(String cur, String endWord, Map<String, List<String>> routes,
                             List<List<String>> ans, List<String> path) {
        if (cur.equals(endWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (!routes.containsKey(cur)) return;

        for (String word :
                routes.get(cur)) {
            path.add(word);
            generatePath(word, endWord, routes, ans, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem126 p = new Problem126();
        String[] word = {"hot","dot","dog","lot","log","cog"};
        List<String> words = new ArrayList<>();
        Collections.addAll(words, word);
        System.out.println(p.findLadders("hit", "cog", words));
    }
}
