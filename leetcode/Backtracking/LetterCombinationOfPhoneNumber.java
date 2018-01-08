package Backtracking;
import javax.swing.text.AbstractDocument;
import java.util.*;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationOfPhoneNumber {
    private static final String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        dfs(res, "", digits, 0, dict);
        return res;
    }
    private void dfs(List<String> res, String prefix, String digits, int pos, String[] dict) {
        if (pos == digits.length()) {
            res.add(prefix);
            return;
        }

        int index = digits.charAt(pos) - '0';
        String cur = dict[index];

        for (int i = 0; i < cur.length(); i++) {
            prefix = prefix + cur.charAt(i);
            dfs(res, prefix, digits, pos+1, dict);
            prefix = prefix.substring(0, prefix.length()-1);
        }
    }


    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber l = new LetterCombinationOfPhoneNumber();
        String digits = "23";
        List<String> res = l.letterCombinations(digits);
        for (String letters : res) {
            System.out.println(letters);
        }
    }
}
