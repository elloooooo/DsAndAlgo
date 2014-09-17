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
		//dp[i][j]��ʾS��ǰi���ַ�ת��ΪT��ǰj���ַ���ת��������
		int[][] dp = new int[S.length()+1][T.length()+1];
		//�����ĳ�ʼ����ʾ��S������ǰ���ַ�ת��Ϊ���ַ����ķ���ֻ��һ����ȥ�������ַ�
		for(int i=0;i<=S.length();i++){
			dp[i][0] = 1;
		}
		
		for(int i=1;i<=S.length();i++){
			for(int j=1;j<=T.length();j++){
				//���S�ĵ�i���ַ���T�ĵ�i���ַ���ͬ
				if(S.charAt(i-1)==T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];//�ؼ�
				}else{
					dp[i][j] = dp[i-1][j];//�ؼ�
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
