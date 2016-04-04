import java.util.Set;


public class Le_139_Word_Break {
	/********************************************************************************************************
	 * 此题目不同于length + start类型的DP, 其有点类似 longest increase subsequence，当前状态取决于其之前的状态，
	 * 因此设置 [start,  current]区间内设置一个指针lastWordLen, 从current往start方向跑, 
	 * 约束条件为lastWordLen <= maxWordLen, 只要其中有一个状态为true，表示从start到lastWordLen可以被切割，
	 * 同时lastWordLen到current是wordDict里的word，canSplit[current]即为true；
	 * 时间复杂度O(n * m)， m为wordDict中最长的单词长度。
	 * 
	 * Statement: canSplit[current]表示到当前current位置，是否可以被切割
	 * Function:  canSplit[current] = current[current - lastWordLen] || (wordDict.contains(lastWord))
	 * Initial:   canSplit[0] = true;
	 * Answer:    canSplit[n]
	 * 
	 * 此题不适合140自底向上的解法，因为此题不需要给出可行解。
	 * 
	 ********************************************************************************************************/
	
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        int maxLen = getMaxLen(wordDict);
        int n = s.length();
        boolean[] canSplit = new boolean[n + 1];
        canSplit[0] = true;
        
        for(int i = 1; i <= n; ++i){
            for(int lastWordLen = 1; lastWordLen <= maxLen && i - lastWordLen >= 0; ++lastWordLen){
                if(canSplit[i - lastWordLen] == true){
                    String lastWord = s.substring(i - lastWordLen, i);
                    if(wordDict.contains(lastWord)){
                        canSplit[i] = true;
                        break;
                    }
                }
            }
        }
        
        return canSplit[n];
    }
    
    public int getMaxLen(Set<String> wordDict){
        int maxLen = 0;
        for(String str : wordDict){
            maxLen = Math.max(maxLen, str.length());
        }
        return maxLen;
    }
}