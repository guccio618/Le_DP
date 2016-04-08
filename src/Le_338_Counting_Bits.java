
public class Le_338_Counting_Bits {
	public int[] countBits(int num) {
        if(num < 0){
            return new int[0];
        } else if(num == 0){
            int[] ways = new int[1];
            ways[0] = 0;
            return ways;
        }
        
        int[] ways = new int[num + 1];
        ways[0] = 0;
        ways[1] = 1;
        int start = 0, end = 1;
        
        for(int i = 2; i <= num; ++i){
        	if(start < end){
        		ways[i] = ways[start] + 1;
        		start++;
        	} else if(start == end){
        		ways[i] = ways[start] + 1;
        		start = 0;
        		end = i;
        	}
        }
        
        return ways;
	}
}
