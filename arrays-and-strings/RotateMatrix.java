/*

    1.7 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
    write a method to rotate the image by 90 degrees. 
    Can you do this in place?

    [
        [1,1,1,1],
        [2,2,2,2],
        [3,3,3,3],
        [4,4,4,4]
    ]

    Rotated 90 degrees

    [
        [4,3,2,1],
        [4,3,2,1],
        [4,3,2,1],
        [4,3,2,1]
    ]

*/

public class RotateMatrix {

    // Taking a sample and going 90 degrees
    // n = 4
    // [0,0] -> [0,3]
    // [0,1] -> [1,3]
    // [0,2] -> [2,3]
    // [0,3] -> [3,3]
    // [row, col] -> [row+count, n - col]


    // brute force approach
    // create a new nxn matrix
    // go through each column from bottom to top then increment row
    // place the value in the rowxcol filling in new matrix
    public int[][] rotateMatrixBruteForce(int[][] image) {
        int[][] rotatedImage = new int[image.length][image.length];
        int rotatedRow = 0;
        int rotatedCol = 0;
        int col = 0;
        int row = image.length - 1;

        while (col < image.length) {
            rotatedImage[rotatedRow][rotatedCol] = image[row][col];
            if (row != 0) {
                // If still traversing up the column, then continue to decrement the row
                // and increment the column for insertion
                row--;
                rotatedCol++;
            } else {
                // If you reach the end of a column, recent the row to the bottom and
                // increment the column to the next column
                row = image.length - 1;
                col++;
                rotatedRow++;
                rotatedCol = 0;
            }
        }

        return rotatedImage;
    }

    // Best solution is one where you are swapping all pieces in place index by index

}