import java.util.ArrayList;


public class Li_091_Minimum_Adjustment_Cost {
	/************************************************************************
	 * Statement:  cost[i][j]: 前i个数修改为值是j时花费的代价
	 * Function:   cost[i][j] = cost[i - 1][k] + abs(j - nums[i])
	 *  
	 ************************************************************************/
	
	public static int MinAdjustmentCost(ArrayList<Integer> nums, int target) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int n = nums.size();
        int[][] cost = new int[n][101];
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; ++i){
            for(int j = 1; j <= 100; ++j){
                cost[i][j] = Integer.MAX_VALUE;
                if(i == 0){
                    cost[i][j] = Math.abs(nums.get(i) - j);
                } else {
                    for(int k = 1; k <= 100; ++k){
                        if(Math.abs(j - k) <= target){
                            int diff = cost[i - 1][k] + Math.abs(nums.get(i) - j);
                            cost[i][j] = Math.min(cost[i][j], diff);
                        }    
                    }
                }
            }
        }
        
        for(int i = 1; i <= 100; ++i){
            ans = Math.min(ans, cost[n - 1][i]);
        }
        
        return ans;
    }
}
