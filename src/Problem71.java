import java.util.Stack;

public class Problem71 {
    public String simplifyPath(String path) {
        if (path.length() == 1) return "/";
        path = path + "/";
        Stack<String> s = new Stack<>();
        s.add("/");
        int len = path.length();
        int start = 0; int end = 0;
        while (end < len) {
            if (path.charAt(end) == '/') {
                if (start != end) {
                    addToStack(path.substring(start, end), s);
                    end++;
                    start = end;
                } else {
                    start++;
                    end++;
                }
            } else {
                end++;
            }
        }

        return stackToString(s);
    }

    private void addToStack(String dir, Stack<String> s) {
        if (!dir.equals(".")) {
            if (dir.equals("..")) {
                if (s.size() != 1) {
                    s.pop();
                }
            } else {
                s.push(dir);
            }
        }
    }

    private String stackToString(Stack<String> s) {
        Stack<String> s1 = new Stack<>();
        while (!s.empty()) {
            s1.add(s.pop());
        }
        s1.pop();
        StringBuilder sb = new StringBuilder();
        while (!s1.empty()) {
            sb.append('/');
            sb.append(s1.pop());
        }
        if (sb.length() == 0) sb.append('/');
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem71 p = new Problem71();

        System.out.println(p.simplifyPath("/a//b////c/d//././/.."));
    }
}
