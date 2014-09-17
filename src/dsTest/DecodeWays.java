package dsTest;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	
	//利用dfs超时
	private int sum=0;
	public int numDecodings(String s) {
		if(s.length()==0){
			return 0;
		}
		dfs(s, 0);
		return sum;
	}

	private void dfs(String s, int index) {
		if(index==s.length()-1||index == s.length()){
			sum ++;
			return;
		}
		int tmp = 0;
		for (int i = index; i < s.length(); i++) {
			tmp = tmp * 10 + (s.charAt(i) - 48);
			if (tmp <= 26) {
				dfs(s, i+1);
			}
		}

	}
	
	//利用动态规划
	public int numDecodingsDP(String s) {
		if(s.length()==0||s.charAt(0)=='0'){
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;
		for(int i=1;i<s.length();i++){
			if(isValid(s,i)&&s.charAt(i)!='0'){
				if(i>1){
					dp[i] = dp[i-1]+dp[i-2];
				}else{
					dp[i] = dp[i-1]+1;
				}
				
			}else if((!isValid(s,i))&&s.charAt(i)=='0'){
				dp[i] = 0;
			}else if(isValid(s,i)&&s.charAt(i)=='0'){
				if(i>1){
					dp[i] = isValid(s,i-1)?dp[i-1]-1:dp[i-1];
				}else{
					dp[i] = dp[i-1];
				}
			}else{
				dp[i] = dp[i-1];
			}
		}
		return dp[s.length()-1];
	}

	private boolean isValid(String s,int i){
		if(s.charAt(i-1)!='0'&&((s.charAt(i-1)-48)*10 + (s.charAt(i)-48))<=26){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String s = "1212";
		DecodeWays d = new DecodeWays();
		int res = d.numDecodingsDP(s);
		System.out.println(res);
	}

}
