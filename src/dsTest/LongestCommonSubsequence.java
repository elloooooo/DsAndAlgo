package dsTest;

/**
 * @author Administrator
 * 最长公共子串问题（LCS）
 */
public class LongestCommonSubsequence {

	public static int getMaxLength(String A,String B){
		//dp[i][j]代表A的第一个到第i个字符与B的第一个到第j个字符中的最长公共字串
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int i=0;i<A.length();i++){
			for(int j=0;j<B.length();j++){
				if(A.charAt(i)==B.charAt(j)){
					dp[i+1][j+1] = dp[i][j]+1;
				}else{
					dp[i+1][j+1] = max(dp[i][j+1],dp[i+1][j]);
				}
			}
		}
		return dp[A.length()][B.length()];
	}
	private static int max(int i, int j) {
		return i>j?i:j;
	}
	public static void main(String[] args) {
		String A = "abcd";
		String B = "becd";
		int res = getMaxLength(A, B);
		System.out.println(res);

	}

}
