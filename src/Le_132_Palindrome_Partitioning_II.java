
public class Le_132_Palindrome_Partitioning_II {
	/**************************************************************************************************************************************************
	 * 双序列动态规划 - (String类)
	 * 		(1). 运用memo[i][j]记录从i到j是否可以划分，减少重复计算；
	 * 		(2). 运用dp[i]记录前i字符的最少切割次数
	 * 
	 **************************************************************************************************************************************************/
	public int minCut(String s) {
        if(s == null || s.length() == 0){
	    	return 0;
	    }
	    
	    int n = s.length();
	    boolean[][] memo = getMemo(s);
	    int[] cut = new int[n];
	    
	    for(int i = 0; i < n; ++i){
	        cut[i] = i;
	    }
	    
	    for(int i = 0; i < n; ++i){
	        for(int j = 0; j <= i; ++j){
	            if(memo[j][i] == true){
	                if(j == 0){
	                    cut[i] = Math.min(cut[i], 0);  // 注意切割代表的意思，这里代表当前i个字符可以构成一个Palindrome时，此时的切割次数为0
	                } else {
	                    cut[i] = Math.min(cut[i], cut[j - 1] + 1);    
	                }
	            }
	        }
	    }
	    
	    return cut[n - 1];
    }
    
    public boolean[][] getMemo(String s){
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        
        for(int i = 0; i < n; ++i){
            memo[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; ++i){
            memo[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        
        for(int length = 2; length < n; ++length){
            for(int start = 0; start + length < n; ++start){
                memo[start][start + length] = memo[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        
        return memo;
    }
}
