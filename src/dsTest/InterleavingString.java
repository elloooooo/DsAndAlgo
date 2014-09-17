package dsTest;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * 
 * Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * 
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
		if ((l1 + l2 )!= l3) {
			return false;
		}
		//tmp[k][i][j]表示s3的前k个字符可以由s1的前i个字符和s2的前j个字符表示
		boolean[][][] tmp = new boolean[l3 + 1][l1 + 1][l2 + 1];
		
		tmp[0][0][0] = true;
		
		for(int k=1;k<=l3;k++){
			for(int i=0;i<=k&&i<=l1;i++){
				int j = k-i;
				if(j>l2){
					continue;
				}
				if(i!=0&&tmp[k-1][i-1][j]&&s1.charAt(i-1)==s3.charAt(k-1)){
					tmp[k][i][j] = true;
				}
				if(j!=0&&tmp[k-1][i][j-1]&&s2.charAt(j-1)==s3.charAt(k-1)){
					tmp[k][i][j] = true;
				}
			}
		}
		
		return tmp[l3][l1][l2];
	}

	public static void main(String[] args) {
		String s1="a";
		String s2="";
		String s3="a";
		InterleavingString i = new InterleavingString();
		System.out.println(i.isInterleave(s1, s2, s3));
		
	}

}
