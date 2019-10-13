import java.util.ArrayDeque;
import java.util.Deque;

public class Problem591 {
    public static void main(String[] args) {
        Problem591 p = new Problem591();

        System.out.println(p.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }

    public boolean isValid(String code) {
        Deque<String> s = new ArrayDeque<>();
        for (int i = 0; i < code.length(); ) {
            if (i > 0 && s.isEmpty()) return false;
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) return false;
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) return false;
                String tagName = code.substring(j, i++);
                if (s.isEmpty() || !tagName.equals(s.pop())) return false;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String tagName = code.substring(j, i++);
                s.push(tagName);
            } else {
                i++;
            }
        }
        return s.isEmpty();
    }
}
