import java.util.HashSet;
import java.util.Set;

/*

    1.8 Write an algorithm such that if an element in an MxN matrix is 0, it's entire row and column are set to zero

    I/O
    [
        [1,4,0]
        [2,3,1]
        [0,1,2]
        [2,1,1]
    ]

    [0,2]
    [2,0]

    Zero out:
    Rows: 0, 2
    Columns: 2, 0

    O/P
    [
        [0,0,0]
        [0,3,0]
        [0,0,0]
        [0,1,0]
    ]
    
*/
public class ZeroMatrix {

    public int[][] zeroMatrix(int[][] input){
        int[][] output = new int[input.length][input[0].length];

        // Collect all the rows and cols which have zeros and create set from them
        // Iterate the new matrix rowxcol and copy the input matrix with the value 
        // or with zero if the col or row exist in the set
        Set<Integer> rowsToZero = new HashSet<>();
        Set<Integer> colsToZero = new HashSet<>();
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if (input[row][col] == 0){
                    rowsToZero.add(row);
                    colsToZero.add(col);
                }
            }
        }

        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if (!rowsToZero.contains(row) && !colsToZero.contains(col)) {
                    output[row][col] = input[row][col];
                }
            }
        }

        return output;
    }

}