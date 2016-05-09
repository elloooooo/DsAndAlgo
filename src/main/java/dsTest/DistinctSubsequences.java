package dsTest;


/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 */
/**
 * @author Administrator
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(S.length()==0){
			return 0;
		}
		//dp[i][j]表示S的前i个字符转化为T的前j个字符的转化方法数
		int[][] dp = new int[S.length()+1][T.length()+1];
		//这样的初始化表示，S的任意前个字符转化为空字符串的方法只有一个：去掉所有字符
		for(int i=0;i<=S.length();i++){
			dp[i][0] = 1;
		}
		
		for(int i=1;i<=S.length();i++){
			for(int j=1;j<=T.length();j++){
				//如果S的第i个字符与T的第i个字符相同
				if(S.charAt(i-1)==T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];//关键
				}else{
					dp[i][j] = dp[i-1][j];//关键
				}
			}
		}
		
		return dp[S.length()][T.length()];
	}

	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		DistinctSubsequences d = new DistinctSubsequences();
		int res = d.numDistinct(s, t);
		System.out.println(res);
		
	}

}
