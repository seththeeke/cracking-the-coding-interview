/*

    1.9 Assume you have a method isSubstring which checks if one word is a substring
    of another. Given 2 strings, s1 and s2, write code to check if s2 is a rotation of s1
    using only one call to isSubstring

    e.g. "waterbottle", "erbottlewat" -> true
    e.g. "helloworld", "fooohworld" -> false

*/

public class StringRotation {

    public boolean isStringRotation(String s1, String s2) {
        // String Rotation is
        // if you rotate s2 by x number of characters as a circular array, it will eventually become s1
        // brute force would be ro rotate s2 by a single character until end of string and then check equality
        // Problem says to use isSubstring
        // Traverse s2 looking for the start of s1 until the end of s2. At that point, you know the beginning of s2 must contain the remainder of s1
        // e.g. traverse s2 until wat -> from s1, you know that isSubstring(s1.substring(3), s2);

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int s1Index = 0;
        for (int s2Index = 0; s2Index < s2.length(); s2Index++) {
            if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
                s1Index++;
            } else {
                s1Index = 0;
            }
        }

        // 0,0 w != e 
        // 0,1 w != r
        // ...
        // 0,8 w == w
        // 1,9 a == a
        // 2,10 t == t
        // End of loop

        if (s1Index == 0) {
            // Only case where s1Index would be 0 is if the 
            // strings were identical which is checked above
            // so no need for substring check in that case
            return false;
        }

        // Return whether the remainder of s1 is a substring of s2
        return isSubstring(s1.substring(s1Index), s2);
    }

    // Optimal Solution
    // Just concatenate s1 with itself and call is substring with s1 as full string and s2 as partial string
    // e.g. "waterbottle", "erbottlewat" -> true
    // isSubstring("waterbottlewaterbottle", "erbottlewat")
    public boolean isStringRotationOptimal(String s1, String s2) {
        StringBuilder s1Builder = new StringBuilder(s1);
        s1Builder.append(s1);
        return isSubstring(s1Builder.toString(), s2);
    }

    private boolean isSubstring(String fullString, String partialString) {
        // Implementation is given, returning true for compilation in the editor
        return true;
    }

}