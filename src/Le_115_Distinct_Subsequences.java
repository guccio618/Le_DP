
public class Le_115_Distinct_Subsequences {
	/**************************************************************************************************************************************************
	 * 双序列动态规划 - (String类)
	 * 		state:      f[i][j] 表示str1的前i个字符中选取str2中的前j个字符有多少种方案; i表示被选取的str的当前字符数， j表示目标str的当前字符数
	 * 		function:   f[i][j] = f[i-1][j] + f[i-1][j-1]   // str1.charAt(i) == str2.charAt(j);
	 * 							= f[i-1][j]                 // str1.charAt(i) != str2.charAt(j);
	 * 					分析： 当str1.charAt(i) == str2.charAt(j)时， 可以保留str1[i], 使得str1[i] == str2[j], 只考虑str1[i-1]和str2[j]的情况， 即f[i-1][j-1]，
	 * 						                                        也可以不保留str1[i], 则只考虑str1[i-1]和str2[j]的情况， 即f[i-1][j]; 注意str2是target字符串，
	 * 																不可以去除str[j]，因为其必须被选上。 
	 * 						  当str1.charAt(i) != str2.charAt(j)时， 只有一种可能，即去除str1[i], 只考虑str1[i-1]和str2[j]的情况，即f[i-1][j];
	 * 		initial:    f[0][j] = 0 && f[i][0] = 1;
	 * 		answer:     f[str1.length][str2.length];
	 * 
	 **************************************************************************************************************************************************/
	
	public int numDistinct(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return 0;
        }
        
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for(int i = 0; i <= len1; ++i){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[len1][len2];
    }
}
