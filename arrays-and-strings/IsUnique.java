import java.util.HashSet;
import java.util.Set;

// Implement an algorithm to determine if a string has all unique characters.

public class IsUnique {

/*

This solution can be done in O(n) worst case time and O(n) worst case space using a Set to collect all characters.
For each character, add it to the set, if the character already exists, then return false.

*/

// Space => O(n) where n is the length of the input
// Time => O(n) where n is the length of the input
public boolean isUnique(String input) {
    Set<Character> charSet = new HashSet<>();
    for (int i = 0; i < input.length(); i++) {
        if (charSet.contains(input.charAt(i))) {
            return false;
        }
    }
    return true;
}

//  What if you cannot use additional data structures?

/*

If no additional data structures could be used, then you can instead sort the string's characters in the string itself.
After that, you can check all the characters in the string and check i and i + 1. If at any point i==i+1, then you know
the string does not contain all unique characters. However, depending on the language, this may require an additional 
data structure to solve Another approach would be to use indexOf with substrings of Strings given the character you are 
checking. If the character you are reading exists in the substring of the remaining characters then it is not all unique.

*/

// Space => O(n) where n is the length of the input - 1 because we are creating a new substring on each pass
// Time => O(n) where n is the length of the input
public boolean isUniqueNoSet(String input) {
    for (int i = 0; i < input.length() - 1; i++) {
        char currChar = input.charAt(i);
        String substring = input.substring(i+1);
        if (substring.indexOf(currChar) > -1) {
            return false;
        }
    }
    return true;
}

}

