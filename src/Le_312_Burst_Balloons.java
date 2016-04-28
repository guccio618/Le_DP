
public class Le_312_Burst_Balloons {
	/*****************************************************************************
	 * 区间DP： 分成小区间，加上合并的代价
	 * state:   dp[i][j]表示从区间i到j的气球能获的气球的分数； k表示最后剩下的是第k个气球；
	 * 			i到j之间内至少要有一个气球。
	 * 
	 * 
	 *****************************************************************************/
	
	public int maxCoins(int[] iNums) {
        if(iNums == null || iNums.length == 0){
            return 0;
        } 
        
        int[] nums = new int[iNums.length + 2];
        int n = nums.length;
        nums[0] = nums[n - 1] = 1;
        int[][] dp = new int[n][n];
        
        for(int i = 1; i < n - 1; ++i){
            nums[i] = iNums[i - 1];
        }
        
        for(int length = 2; length < n; ++length){
            for(int start = 0; start + length < n; ++start){
                int end = start + length;
                for(int k = start + 1; k < end; ++k){ // k的起点和终点选择，考虑！
                    dp[start][end] = Math.max(dp[start][end], dp[start][k] + dp[k][end] + nums[start] * nums[k] * nums[end]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
