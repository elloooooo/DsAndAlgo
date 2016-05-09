package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * ������Ӵ����⣨LCS��
 */
public class LongestCommonSubsequence {

	public static int getMaxLength(String A,String B){
		//dp[i][j]����A�ĵ�һ������i���ַ���B�ĵ�һ������j���ַ��е�������ִ�
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
	
	//��¼��ִ�
	public static String getLongestSubString(String A,String B){
		List<Character> res = new ArrayList<Character>();
		//dp[i][j]����A�ĵ�һ������i���ַ���B�ĵ�һ������j���ַ��е�������ִ�
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int i=0;i<A.length();i++){
			for(int j=0;j<B.length();j++){
				if(A.charAt(i)==B.charAt(j)){
					res.add(A.charAt(i));
					dp[i+1][j+1] = dp[i][j]+1;
				}else{
					dp[i+1][j+1] = max(dp[i][j+1],dp[i+1][j]);
				}
			}
		}
		StringBuffer sbf = new StringBuffer();
		
		for(char elem:res){
			sbf.append(elem);
		}
		return sbf.toString();
	}
	
	
	public static void main(String[] args) {
		String A = "abdef";
		String B = "abcde";
		String res = getLongestSubString(A, B);
		System.out.println(res);

	}

}
