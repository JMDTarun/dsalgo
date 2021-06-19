package dsalgo.leetcode.medium;

public class MaximalRectangle {
	public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] temp = new int[rows + 1][cols + 1];
        int answer = 0;
        for (int i=1;i<=rows; i++) {
            for (int j=1; j<=cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    temp[i][j] = Math.min(Math.min(temp[i][j-1] , temp[i-1][j-1]), temp[i-1][j]) + 1;
                    answer = Math.max(temp[i][j], answer);
                }
            }
        }
        return answer * answer;
        
    }
}
