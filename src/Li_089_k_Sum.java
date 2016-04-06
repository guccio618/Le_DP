
public class Li_089_k_Sum {
	/************************************************************************
	 * 此题可以看成背包问题的follow up
	 * 可以进行空间优化
	 *  
	 ************************************************************************/
	// 未进行空间优化
	public int  kSum(int A[], int k, int target) {
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    f[i][j][t] = f[i - 1][j][t];
                    if (t >= A[i - 1]) {
                        f[i][j][t] += f[i - 1][j - 1][t - A[i - 1]];
                    }
                } 
            } 
        } 
        
        return f[n][k][target];
    }
	
	
	/*************************************************/
	// 空间优化后
	public int  kSum2(int A[], int k, int target) {
        int n = A.length;
        int[][][] dp = new int[2][k + 1][target + 1];
        
        for (int i = 0; i < 2; i++) {
            dp[i][0][0] = 1;
        }
        
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= k && j <= i; ++j){
                for(int t = 1; t <= target; ++t){
                    dp[i % 2][j][t] = dp[(i - 1) % 2][j][t];
                    if(t >= A[i - 1]){
                        dp[i % 2][j][t] += dp[(i - 1) % 2][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        
        return dp[n % 2][k][target];
    }
}
