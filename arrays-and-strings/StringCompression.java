/*

    1.6 Implement a method to perform basic string compression using the counts of the repeated characters. You can assume the string has only uppercase and lowercase letters.
    If the shortened string would be larger than the original string, then return the original string

    e.g. aabcccccaaa -> a2b1c5a3
*/


public class StringCompression {

    // Space and Time => O(n) where n is the length of the string because we are creating the string builder and traversing every character
    public String compress(String input) {
        // iterate over the input
        // track a current character
        // append the current character to the string builder
        // while the character remains the same, increment a counter
        // when it changes, append the counter to the string builder
        // if string builder is longer than input, return input
        StringBuilder output = new StringBuilder();
        if (input.length() < 2) {
            return input;
        }

        char currChar = input.charAt(0);
        output.append(currChar);
        int counter = 1;
        for (int i = 1; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (currChar == inputChar) {
                counter++;
            } else {
                // print count of previous char
                output.append(String.valueOf(counter));
                // print new char to track
                output.append(inputChar);
                currChar = inputChar;
                counter = 1;
            }
        }

        if (output.length() < input.length()) {
            return output.toString();
        }
        return input;
    }

}