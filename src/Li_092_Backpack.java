
public class Li_092_Backpack {
	/************************************************************************
	 * Statement:  dp[i][j]: 前i个item是否可以填满j体积的背包
	 * Function:   dp[i][j] = dp[i - 1][j] || dp[i - 1][j - item[i]]
	 * 			   也许前i - 1个item已经将j体积的背包填满。
	 * Initial:    dp[i][0] = true;
	 * Answer:     寻找为true时的最大capacity
	 *  
	 ************************************************************************/
	
	// 滚动数组空间优化过之后, space O(n)
	public int backPack(int capacity, int[] Item) {
	    if(capacity <= 0 || Item == null || Item.length == 0){
	        return 0;
	    }
	    
	    int maxCapacity = 0;
	    int n = Item.length;
	    boolean[][] dp = new boolean[2][capacity + 1];
	    dp[0][0] = true;     // 初始状态均一致，为true，所以考虑可以用滚动数组进行优化
	    dp[1][0] = true;
	    
	    for(int i = 1; i <= n; ++i){
	        for(int j = 1; j <= capacity; ++j){
	            dp[i % 2][j] = dp[(i - 1) % 2][j];
	            if(j >= Item[i - 1]){
	                dp[i % 2][j] = dp[i % 2][j] || dp[(i - 1) % 2][j - Item[i - 1]];
	            }
	            if(dp[i % 2][j] == true){
	                maxCapacity = Math.max(maxCapacity, j);
	            }
	        }
	    }
	    
	    return maxCapacity;
    }
	
	
	
	/******************************************************/
	// 未进行过空间优化, space O(n^2)
	public int backPack2(int capacity, int[] Item) {
	    if(capacity <= 0 || Item == null || Item.length == 0){
	        return 0;
	    }
        
        int n = Item.length;
        boolean[][] dp = new boolean[n + 1][capacity + 1];
        int ans = 0;
        
        for(int i = 0; i <= n; ++i){
            dp[i][0] = true;
        }
        
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= capacity; ++j){
                dp[i][j] = dp[i - 1][j];
                if(j >= Item[i - 1]){
                    dp[i][j] |= dp[i - 1][j - Item[i - 1]];
                }
                if(dp[i][j] == true){
                    ans = Math.max(ans, j);
                }
            }
        }
        
        return ans;
    }
}
