import java.util.Stack;


public class Le_032_Longest_Valid_Parentheses {
	// using stack
	public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int start = -1;
        int maxLen = 0;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else{
                if(stack.isEmpty()){
                    start = i;
                } else {
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLen = Math.max(maxLen, i - start);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        
        return maxLen;
    }
	
	
	// using DP, but will exceed time limit
	public int longestValidParentheses2(String s) {
		if(s == null || s.length() == 0){
            return 0;
        }
        
        char[] array = s.toCharArray();
        int n = array.length;
        boolean[][] valid = new boolean[n][n];
        int maxLen = 0;
        
        for(int i = 0; i < n - 1; ++i){
            valid[i][i + 1] = (array[i] == '(' && array[i + 1] == ')');
            if(valid[i][i + 1] == true){
                maxLen = 2;
            }
        }
        
        for(int length = 2; length < n; length++){
            for(int start = 0; start + length < n; ++start){
                int end = start + length;
                valid[start][end] |= valid[start + 1][end - 1] && array[start] == '(' && array[end] == ')';
                valid[start][end] |= valid[start][end - 2] && array[end - 1] == '(' && array[end] == ')';
                valid[start][end] |= valid[start + 2][end] && array[start] == '(' && array[start + 1] == ')';
                if(valid[start][end] == true){
                    maxLen = Math.max(maxLen, length + 1);
                }
            }
        }
        
        return maxLen;       
	}
}
