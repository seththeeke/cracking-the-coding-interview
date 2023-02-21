import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
    1.4 - Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards as it is backwards.
    A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

    Basically, can you rearrange the string in a way that makes a palindrome?
*/

public class PalindromPermutation {

    /*
        Constraints of a palindrome:
            a. An even number of all characters except 1 character for odd lengths. e.g. tfataccaf -> tfcaaacft
            b. All even numbers of all characters for even length strings
    */

    // Space => O(n) where n is the number of characters in the input because of the map storage
    // Time => O(n) where n is the number of characters in the input because we are iterating over each character
    public boolean palindromePermutation(String input) {
        // Spaces don't matter for the result
        String trimmed = input.trim();
        Map<Character, Integer> charCount = countCharacters(trimmed);

        boolean oddFound = false;
        for (Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() % 2 > 0) {
                if (input.length() % 2 == 0) {
                    return false;
                }
                if (oddFound) {
                    return false;
                } else {
                    oddFound = true;
                }
            }
        }

        return true;
    }

    private Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character currChar : input.toCharArray()) {
            if (!charCount.containsKey(currChar)) {
                charCount.put(currChar, 0);
            }
            charCount.put(currChar, charCount.get(currChar) + 1);
        }

        return charCount;
    }
}