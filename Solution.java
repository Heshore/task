package Assesment;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentCombination, List<String> result, Map<Character, String> digitToLetters) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(digits, index + 1, currentCombination, result, digitToLetters);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println(combinations);
    }
}
