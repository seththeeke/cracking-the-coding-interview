/*

    There are three types of edits that can be performed on strings: Insert a character, remove a character, or replace a character.
    Given two strings, write a function to check is they are one edit or zero edits away. 

    pale, ple -> true
    pales, pale -> true
    pale, bale -> true
    pale, bake -> false
*/

public class OneMoveAway {


    /*
        Conditions for one move away
        1. Strings must have a length difference no more than 1
        2. Strings must have a character difference no more than 1
        3. a[i] must equal b[i] or b[i+1] in all cases except for one -> order must be "fuzzy correct"
    */
    public boolean oneMoveAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }
        
        if (a.length() == b.length()) {
            // Same length
            // iterate the characters in the string, if there is more than one difference, then return false
            return oneMoveAwaySameLength(a, b);
        } else {
            // Different length
            // iterate the characters with the longer being the first of the two
            // when finding a mistake, set a boolean to check i - 1 on the second string
            // if any more incorrect strings, then return false
            // else return true
            if (a.length() > b.length()) {
                return oneMoveAwayDiffLengthIndexes(a, b);
            }
            return oneMoveAwayDiffLengthIndexes(b, a);
        }
    }

    private boolean oneMoveAwaySameLength(String a, String b) {
        boolean mistakeFound = false;
        for (int i = 0; i < a.length(); i++) {
            if (!(a.charAt(i) == b.charAt(i))) {
                if (mistakeFound) {
                    return false;
                }
                mistakeFound = true;
            }
        }
        return true;
    }

    // This should work but is substantially less readable than the two index approach
    private boolean oneMoveAwayDiffLength(String longString, String shortString) {
        boolean mistakeFound = false;
        for (int i = 0; i < longString.length(); i++) {
            // need to catch index out of bounds cases for shortString
            if (mistakeFound) {
                // This should never hit index out of bounds cases
                if (!(longString.charAt(i) == shortString.charAt(i-1))) {
                    if (mistakeFound) {
                        return false;
                    }
                    mistakeFound = true;
                }
            } else {
                if (i == shortString.length()) {
                    // This covers the case of the index out of bounds on the last character
                    return true;
                }
                if (!(longString.charAt(i) == shortString.charAt(i))) {
                    if (mistakeFound) {
                        return false;
                    }
                    mistakeFound = true;
                }
            }
        }
        return true;
    }

    // The simpler approach is to use two indexes and increment them according to the check
    private boolean oneMoveAwayDiffLengthIndexes(String longString, String shortString) {
        int longIndex = 0;
        int shortIndex = 0;
        boolean mistakeFound = false;
        while (longIndex < longString.length() && shortIndex < shortString.length()) {
            if (longString.charAt(longIndex) != shortString.charAt(shortIndex)) {
                if (mistakeFound) {
                    return false;
                }
                mistakeFound = true;
                longIndex++;
            } else {
                longIndex++;
                shortIndex++;
            }
        }
        return true;
    }

}