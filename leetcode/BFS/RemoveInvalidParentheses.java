package BFS;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean reached = false;

        queue.offer(s);
        visited.add(s);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String str = queue.poll();

                if(isValid(str)) {
                    res.add(str);
                    reached = true;
                }

                if(!reached) {
                    for(int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                        String newStr = str.substring(0, j) + str.substring(j+1);

                        if (!visited.contains(newStr)) {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }

            if (reached) break;
        }

        return res;
    }

    private boolean isValid(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') {
                if(count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        String p = "()())()";
        System.out.println(r.removeInvalidParentheses(p));
    }
}
