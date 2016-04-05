import java.util.Stack;


public class Le_084_Largest_Rectangle_in_Histogram {
	/*****************************************
	 * 单调栈
	 * 
	 *****************************************/
	
	public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        } 
        
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i <= n; ++i){
            int currentHeight = i == n ? -1 : heights[i];              // 利于最后一个元素出栈
            while(!stack.isEmpty() && currentHeight <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;  // 取值范围
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        
        return maxArea;
	}
}
