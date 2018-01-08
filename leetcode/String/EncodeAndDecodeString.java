package String;
import java.util.*;

public class EncodeAndDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();

        int start = 0;
        while(start < s.length()) {
            int index = s.indexOf('#', start);
            int size = Integer.parseInt(s.substring(start, index));

            res.add(s.substring(index+1, index+1+size));
            start += index + 1 + size;
        }

        return res;
    }

    public static void main(String[] args) {
        EncodeAndDecodeString e = new EncodeAndDecodeString();
        List<String> list = Arrays.asList("C#","&","~Xp|F","R4QBf9g=_");
        System.out.println(e.decode(e.encode(list)));
    }
}
