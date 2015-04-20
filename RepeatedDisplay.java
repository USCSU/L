package LinkedIn;

/**
 * Created by Trace_route on 11/22/14.
 */
public class RepeatedDisplay {
    public static void main(String[] args) {
// TODO Auto-generated method stub

        int[] nums = { 1, 2, 3, 4, 5, 6, 7,8,9};
        p(nums, 3);
    }
    public static void p(int[] nums, int col){
        int rows = nums.length/col;
        int last = nums.length%col;
        if(last>0) rows++;
        int[][] matrix = new int[rows][col];
        int index =0;
        for(int i = 0;i<col;i++){
            for(int j =0;j<rows;j++){
                if(last!=0&&j==rows-1&&i>=last) continue;
                matrix[j][i] = nums[index++];
                if(index==nums.length) break;
            }
            if(index == nums.length) break;
        }
        for(int i =0;i<matrix.length;i++){
            System.out.println();
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
        }
    }
    private static void printArr(int[] nums, int numCols) {

        int numRows = nums.length / numCols;
        int numLastRow = nums.length % numCols;
        if (numLastRow > 0) {
            numRows++;
        }
        System.out.println(numRows +" --> "+numLastRow);

        int[][] matrix = new int[numRows][numCols];
        int arrIndex = 0;

        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                // If we're on the bottom row and over the number
                // of items to be put on it just skip this iteration
                if ((j == numRows - 1)&& i >= numLastRow) {
                    continue;
                }
                matrix[j][i] = nums[arrIndex];
                arrIndex++;
                if (arrIndex >= nums.length)
                    break;
            }
            if (arrIndex >= nums.length)
                break;
        }

        arrIndex = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] > 0)
                    System.out.print(String.format("%3d", matrix[i][j]));
                if (arrIndex >= nums.length)
                    break;
            }
            System.out.println();
            if (arrIndex >= nums.length)
                break;
        }
    }

}

