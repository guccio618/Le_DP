
public class Le_053_Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] sum = new int[nums.length];
        int preSum = nums[0];
        int curSum = nums[0];
        int max = nums[0];
        int n = nums.length;
        
        for(int i = 1; i < n; ++i){
            curSum = Math.max(preSum + nums[i], nums[i]);
            preSum = curSum;
            max = Math.max(max, curSum);
        }
        
        return max;
    }
}
