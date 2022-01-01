package array;

/**
 * 前缀和
 */
public class Array304 {
    class NumMatrix {
        // preNums[x][y] 表示从 matrix[0][0] 到 matrix[x-1][y-1] 的矩阵和
        private int preNums[][];

        public NumMatrix(int[][] matrix) {
            this.preNums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < preNums.length; i++) {
                for (int j = 1; j < preNums[0].length; j++) {
                    this.preNums[i][j] = matrix[i - 1][j - 1]
                            + this.preNums[i - 1][j]
                            + this.preNums[i][j - 1]
                            - this.preNums[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return this.preNums[row2 + 1][col2 + 1]
                    - this.preNums[row1][col2 + 1]
                    - this.preNums[row2 + 1][col1]
                    + this.preNums[row1][col1];
        }
    }



}
