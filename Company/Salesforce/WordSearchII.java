package Company.Salesforce;
import java.util.*;
/**
 * Created by Doodle on 3/7/18.
 */
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String item = "";
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] != null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }

        p.item = word;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) return false;
            p = p.children[index];
        }

        return p.item.equals(word);
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.children[index] == null) return false;
            p = p.children[index];
        }

        return true;
    }
}

public class WordSearchII {
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(res);
    }

    private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (visited[x][y]) return;

        str += board[x][y];
        if (!trie.startsWith(str)) return;
        if (trie.search(str)) res.add(str);

        visited[x][y] = true;

        dfs (board, visited, str, x+1, y, trie);
        dfs (board, visited, str, x-1, y, trie);
        dfs (board, visited, str, x, y+1, trie);
        dfs (board, visited, str, x, y-1, trie);

        visited[x][y] = false;
    }
}
