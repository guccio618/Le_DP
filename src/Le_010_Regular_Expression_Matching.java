public class Le_010_Regular_Expression_Matching {
	/*************************************************************************
	 * Two situations:
	 * (1) dp[i][j-2] is true, and there is 0 preceding element of '*';
	 * (2) The last character of s should match the preceding element of '*'; 
	 *     And, dp[i-1][j] should be true;
	 * 
	 *************************************************************************/
	
	public boolean isMatch(String s, String p) {
		int sL = s.length(), pL = p.length();
		boolean[][] dp = new boolean[sL + 1][pL + 1];
		dp[0][0] = true;                     // If s and p are "", isMathch() returns true;

		for (int i = 0; i <= sL; i++) {      // j starts from 1, since dp[i][0] is false when i != 0;
			for (int j = 1; j <= pL; j++) {
				char c = p.charAt(j - 1);    // p[j-1]相当于p中的第j个char,即dp中的j
				if (c != '*') {    // The previous character of s and p should match; And, dp[i-1][j-1] is true;
					dp[i][j] = (i > 0 && dp[i - 1][j - 1] && (c == '.' || c == s.charAt(i - 1)));
				} else {
					// 不使用*, 如 "c*", 此时表示0个c,因此向前跳2步,判断此时是否为true
					// 如a*能表示a,即*可以表示为其前面的char
					dp[i][j] = ((j > 1 && dp[i][j - 2]) || 
							(i > 0 && dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))));
				}
			}
		}
		return dp[sL][pL];
	}
}
