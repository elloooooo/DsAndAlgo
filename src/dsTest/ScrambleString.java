package dsTest;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		//如果长度不同，显然false
		if(s1.length()!=s2.length()){
			return false;
		}
		int length = s1.length();
		//dp[i][j][k]表示s1[i]~s1[i+k-1]与s2[j]~s2[j+k-1]是否为为ScrambleString，
		boolean[][][] dp = new boolean[length][length][length+1];
		for(int k=1;k<=length;k++){
			for(int i=0;i<=length-k;i++){
				for(int j=0;j<=length-k;j++){
					if(k==1){
						boolean flag = s1.charAt(i)==s2.charAt(j);
						dp[i][j][k] = flag;
					}else{
						//枚举分割点，检测每种分割点情况下是否可以为ScrambleString
						for(int l=1;l<k;l++){
							//s1左=s2左&&s1右=s2右||s1左=s2右&&s1右=s2左
							if((dp[i][j][l]&&dp[i+l][j+l][k-l])||(dp[i][j+k-l][l]&&dp[i+l][j][k-l])){
								dp[i][j][k] = true;
								break;
							}
						}
					}
				}
			}
		}
		return dp[0][0][length];
	}

	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgeat";
		ScrambleString s = new ScrambleString();
		System.out.println(s.isScramble(s1, s2));

	}

}
