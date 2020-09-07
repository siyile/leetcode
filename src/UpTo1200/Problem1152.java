package UpTo1200;

import java.util.*;

public class Problem1152 {
    Map<String, Integer> smap = new HashMap<>();

    public static void main(String[] args) {
        Problem1152 p = new Problem1152();
        System.out.println(p.mostVisitedPattern(new String[]{"him", "mxcmo", "jejuvvtye", "wphmqzn", "uwlblbrkqv", "flntc", "esdtyvfs", "nig", "jejuvvtye", "nig", "mxcmo", "flntc", "nig", "jejuvvtye", "odmspeq", "jiufvjy", "esdtyvfs", "mfieoxff", "nig", "flntc", "mxcmo", "qxbrmo"}, new int[]{113355592, 304993712, 80831183, 751306572, 34485202, 414560488, 667775008, 951168362, 794457022, 813255204, 922111713, 127547164, 906590066, 685654550, 430221607, 699844334, 358754380, 301537469, 561750506, 612256123, 396990840, 60109482}, new String[]{"k", "o", "o", "nxpvmh", "dssdnkv", "kiuorlwdcw", "twwginujc", "evenodb", "qqlw", "mhpzoaiw", "jukowcnnaz", "m", "ep", "qn", "wxeffbcy", "ggwzd", "tawp", "gxm", "pop", "xipfkhac", "weiujzjcy", "x"}));
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> map = new HashMap<>();
        for (int i = 0; i < timestamp.length; i++) {
            if (!map.containsKey(username[i]))
                map.put(username[i], new ArrayList<>());
            List<Visit> tmp = map.get(username[i]);
            tmp.add(new Visit(timestamp[i], website[i]));
        }

        for (List<Visit> visits : map.values()) {
            if (visits.size() < 3) continue;
            Collections.sort(visits);
            dfs(visits, 0, new StringBuilder(), 0, new HashSet<>());
        }

        List<String> l = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, Integer> entry : smap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                l = new ArrayList<>();
                l.add(entry.getKey());
            } else if (entry.getValue() == max) {
                l.add(entry.getKey());
            }
        }


        l.sort(Comparator.naturalOrder());
        String[] x = l.get(0).split("!");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ans.add(x[i]);
        }
        return ans;
    }

    private void dfs(List<Visit> visits, int s, StringBuilder sb, int cnt, Set<String> visited) {
        if (cnt == 3) {
            String tmp = sb.toString();
            if (visited.add(tmp)) {
                smap.put(tmp, smap.getOrDefault(tmp, 0) + 1);
            }
            return;
        }
        for (int i = s; i < visits.size(); i++) {
            sb.append(visits.get(i).website);
            sb.append('!');
            dfs(visits, i + 1, sb, cnt + 1, visited);
            sb.delete(sb.length() - visits.get(i).website.length() - 1, sb.length());
        }
    }

    class Visit implements Comparable<Visit> {
        int timestamp;
        String website;

        Visit(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }

        @Override
        public int compareTo(Visit o) {
            return timestamp - o.timestamp;
        }
    }
}
