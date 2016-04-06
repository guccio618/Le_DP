
public class Le_091_Decode_Ways {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;  // 额外加一位，用于结果输出
        memo[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        
        for(int i = n - 2; i >= 0; --i){
            if(s.charAt(i) == '0'){  // 注意当其为0时，memo[i] = 0;
                continue;
            }
            memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
        }
        
        return memo[0];
    }
}
