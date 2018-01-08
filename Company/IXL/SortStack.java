package Company.IXL;
import java.util.*;
/**
 * Created by Doodle on 2/3/18.
 */
public class SortStack {
    private static Stack<Integer> s;

    private static void sortedInsert(int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        int tmp = s.pop();
        sortedInsert(x);
        s.push(tmp);
    }

    private static void sortStack() {
        if (!s.isEmpty()) {
            int x = s.pop();
            sortStack();
            sortedInsert(x);
        }
    }

    private static void printStack() {
        List<Integer> list = new ArrayList<>();
        while (!s.isEmpty()) {
            list.add(s.pop());
        }

        Collections.reverse(list);
        System.out.println(list.toString());

    }

    public static void main(String[] args) {
        s = new Stack<Integer>();
        s.push(-30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        sortStack();
        printStack();

    }
}
