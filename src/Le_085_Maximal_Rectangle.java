import java.util.Stack;


public class Le_085_Maximal_Rectangle {
	/*****************************************
	 * 单调栈, 此题为84的follow up
	 * 
	 *****************************************/
	
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] heights = new int[row][col];
        int maxArea = 0;
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(i == 0){
                    heights[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    heights[i][j] = (matrix[i][j] == '1') ? heights[i - 1][j] + 1 : 0;  // j从0开始
                }
            }
        }
        
        for(int i = 0; i < row; ++i){
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j <= col; ++j){
                int currentHeight = (j == col) ? -1 : heights[i][j];
                while(!stack.isEmpty() && currentHeight <= heights[i][stack.peek()]){
                    int h = heights[i][stack.pop()];
                    int w = (stack.isEmpty()) ? j : j - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(j);
            }
        }
        
        return maxArea;
    }

}
