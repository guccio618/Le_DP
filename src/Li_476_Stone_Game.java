
public class Li_476_Stone_Game {
	/************************************************************************
	 * 此题在[i,j]区间求合并花费，取决于[i, k]，[k+1, j]区间内的状态；由于k不固定，因此为
	 * 区间类动态规划。
	 * 
	 * Statement: 
	 * 		sum[i][j]: 表示本次合并i到j所花费的总花费
	 * 		dp[i][j]:  表示把第i到第j个石子合并到一起的最小花费
	 * Function: dp[i][j] = dp[i][k] + dp[k + 1][j] + sum[i][j]
	 * Initial:  dp[i][i] = 0;
	 * Answer:   dp[0][n-1]
	 * 
	 ************************************************************************/
	
	public int stoneGame(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        int[][] sum = new int[len][len];  // i到j的石子总和
        
        for(int i = 0; i < len; ++i){
            sum[i][i] = nums[i];
        }
        
        for(int i = 0; i < len; ++i){
            for(int j = i + 1; j < len; ++j){
                sum[i][j] = sum[i][j - 1] + nums[j];
            }
        }
        
        for(int i = 0; i < len; ++i){
            for(int j = 0; j < len; ++j){
                if(i != j){
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int length = 1; length < len; ++length){
        	for(int start = 0; start + length < len; ++start){
        		for(int k = start; k < start + length; ++k){
        			dp[start][start + length] = Math.min(dp[start][start + length], dp[start][k] + dp[k + 1][start + length] + sum[start][start + length]);
        		}
        	}
        }
        
        return dp[0][len - 1];
    }
}
