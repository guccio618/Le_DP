public class Le_010_Regular_Expression_Matching {
	/*************************************************************************
	 * Two situations:
	 * (1) dp[i][j-2] is true, and there is 0 preceding element of '*';
	 * (2) The last character of s should match the preceding element of '*'; 
	 *     And, dp[i-1][j] should be true;
	 * (3). 此题应考虑：*不能出现在第一个位置！
	 *************************************************************************/
	
	public boolean isMatch(String s, String p) {
		if(s == null || p == null){     // 可有可无
            return false;
        }
		
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;          // If s and p are "", isMathch() returns true;
        
        for(int i = 1; i <= sLen; ++i){
            dp[i][0] = false;
        }
        
        for(int j = 1; j <= pLen; ++j){
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];    // 注意这里不能遇到dp[0][j] == false就break, test case: c*c*
        }
        
        for(int i = 1; i <= sLen; ++i){
            for(int j = 1; j <= pLen; ++j){
                int c = p.charAt(j - 1);     // p[j-1]相当于p中的第j个char,即dp中的j
                if(c != '*'){
                    dp[i][j] = (dp[i - 1][j - 1] && (c == '.' || c == s.charAt(i - 1)));
                } else {    			// 不使用*, 如 "c*", 此时表示0个c,因此向前跳2步,判断此时是否为true
										// 如a*能表示a,即*可以表示为其前面的char
                    if(j > 1){              // 通常情况下，第一个字符不会为"*"， 可以不用考虑
                        dp[i][j] = (dp[i][j - 2]) || dp[i][j - 1] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                    }      // x*表示0，1， 2+个x时的情况
                }
            }
        }
        
        return dp[sLen][pLen];
     }  
	
	
	public static void main(String[] args){
		Le_010_Regular_Expression_Matching t = new Le_010_Regular_Expression_Matching();
		String str1 = "cb";
		String str2 = "c*";
		System.out.println(t.isMatch(str1, str2));
	}
}
