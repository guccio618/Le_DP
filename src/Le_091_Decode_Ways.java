/**********************************************
 * 1. decode way取决于当前digit和前一个digit的值
 * 2. 当前digit分三种情况： 0, 1~6, 7~9
 * 
 **********************************************/


public class Le_091_Decode_Ways {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        char[] letters = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;          // 初始值为0，用于结果输出 ！！！
        dp[1] = letters[0] == '0' ? 0 : 1;
        
        for(int i = 2; i <= n; i++){
            int current = letters[i - 1] - '0';
            int previous = letters[i - 2] - '0';
            
            if(current == 0){
                if(previous == 1 || previous == 2){
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else if(current <= 6){
                if(previous == 1 || previous == 2){
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if(previous == 1){
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        
        return dp[n];
    }
	
	
	
	public int numDecodings2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;                 // 额外加一位，用于结果输出 ！！！
        memo[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        
        for(int i = n - 2; i >= 0; --i){
            if(s.charAt(i) == '0'){  // 注意当其为0时，memo[i] = 0;
                continue;
            }
            memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
        }
        
        return memo[0];
    }
	
	
	
	
	public static void main(String[] args){
		Le_091_Decode_Ways t = new Le_091_Decode_Ways();
		System.out.println(t.numDecodings("199"));
	}
}
