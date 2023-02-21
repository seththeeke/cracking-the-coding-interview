// Write a method to replace all spaces in a string with %20. 
// You may assume that the string has sufficient space at the end 
// to hold the additional characters, and that you are given the "true" length of the string.

public class URLify {
    /*

    This can be solved pretty quickly with a simple split and join command. Splitting on the spaces and then
    joining on %20. However, since the string has extra spaces at the end, you would need to trim the string first

    */

    // Space => O(n) where n is the length of the input. Splitting and joining will create new arrays and strings
    // Time => O(n) where n is the length of the input. The split and join commands would traverse the length of the array
    public String urlify(String input, int length) {
        String trimmedString = input.trim();
        String[] splitArray = trimmedString.split(" ");
        return String.join("%20", splitArray);
    }

}

