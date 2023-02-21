import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// Given two strings, write a method to determine if one is a permutation of the other

public class CheckPermutations {

/*

Assuming a permutation is simple the same characters in both strings, then one approach is to sort the strings
and then check if they are equal. 

*/

// Space => O(n) where n is the length of the two strings
// Time => O(nlogn) where n is the length of the two strings. This is because of the quicksort from Arrays.sort
public boolean checkPermutations(String one, String two) {
    if (one.length() != two.length()) {
        return false;
    }

    return sortString(one).equalsIgnoreCase(sortString(two));
}

private String sortString(String str) {
    char[] characterArr = str.toCharArray();

    Arrays.sort(characterArr);

    return characterArr.toString();
}

/*

Another approach would be to use a map and do a simple character count. You
can then verify the permutation by going through all entries in the map and ensuring all the values are the same.

*/

// Space => O(n) where n is the length of the strings. It comes from the creation of the map objects
// Time => O(n) where n is the length of the strings. This is from building the map from all characters
public boolean checkPermutationsCharCount(String one, String two) {
    if (one.length() != two.length()) {
        return false;
    }

    Map<Character, Integer> charCountOne = getCharCountForString(one);
    Map<Character, Integer> charCountTwo = getCharCountForString(two);

    if (charCountOne.keySet().size() != charCountTwo.keySet().size()) {
        return false;
    }

    for (Entry<Character, Integer> entry : charCountOne.entrySet()) {
        Character key = entry.getKey();
        if (charCountTwo.get(key) != entry.getValue()) {
            return false;
        }
    }

    return true;
}

private Map<Character, Integer> getCharCountForString(String str) {
    Map<Character, Integer> charCount = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
        Character currChar = str.charAt(i);
        if (!charCount.containsKey(currChar)) {
            charCount.put(currChar, 0);
        }
        charCount.put(currChar, charCount.get(currChar) + 1);
    }

    return charCount;
}

}

