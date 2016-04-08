
public class Le_044_Wildcard_Matching {
	/*******************************************************************
	 * 
	 *  
	 *******************************************************************/
	// by other, time complexity O(n^2), space O(n^2)
	// test case: "" 2
	public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
		boolean[][] matrix = new boolean[m + 1][n + 1];    // 表示s中的0~i可以匹配p中的0~j		
		matrix[0][0] = true;                // s="" p="" is true
		
		int count = 0;      // this part is for checking, will accelerate the speed
		for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') count++;
        }
        if (count == 0 && m != n) {
            return false;
        } else if (n - count > m) {
            return false;
        }
		
		for (int i = 1; i <= n; i++) {      // Handle cases like s="" p="****"
			if (p.charAt(i - 1) == '*'){
				matrix[0][i] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char c = p.charAt(j - 1);
				if (c != '*'){
					matrix[i][j] = matrix[i - 1][j - 1] && (s.charAt(i - 1) == c || c == '?');
				} else {
					// two cases: 
					// (1). matrix[i][j-1] => * is empty
					// (2). matrix[i-1][j] => match sequence of characters
					matrix[i][j] = matrix[i][j - 1] || matrix[i - 1][j];
				}
			}
		}
		
		return matrix[m][n];
    }
}
