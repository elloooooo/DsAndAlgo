package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 */
public class PalindromePartitioning {
	//��̬�滮���ɻ��ּ�¼����һ����ά�����¼
	private void dp(String s,char [][] palindrome_map){
		for(int i=s.length()-1;i>=0;i--){
			for(int j=i;j<s.length();j++){
				if(i==j){
					palindrome_map[i][j] = 1;
				}else{
					if(s.charAt(i)==s.charAt(j)){
						if(j==i+1||palindrome_map[i+1][j-1]==1){
							palindrome_map[i][j] = 1;
						}
					}
				}
			}
		}
	}
	//��ά���鱻��Ϊһ��ͼ�ı�ʾ������������ȱ��������ÿһ�黮��
	private void dfs(String s, int begin, char[][] palindrome_map,
			ArrayList<String> array, List<List<String>> result) {
		if(begin==s.length()){
			result.add(array);
			return;
		}
		for(int i=begin;i<s.length();i++){
			if(palindrome_map[begin][i]==1){
				ArrayList<String> tmp = new ArrayList<String>(array);
				tmp.add(s.substring(begin,i+1));
				dfs(s,i+1,palindrome_map,tmp,result);
			}
		}
		
	}
	
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();  
        ArrayList<String> array = new ArrayList<String>();  
  
        if(s==null||s.length()==0) {  
            result.add(array);  
            return result;  
        }  
        char [][] palindrome_map = new char[s.length()][s.length()];  
          
        dp(s, palindrome_map);  
        dfs(s,0,palindrome_map,array,result);  
        return result;  
	}

	

	public static void main(String[] args) {
		String t = "aab";
		PalindromePartitioning p = new PalindromePartitioning();
		List<List<String>> res = p.partition(t);

	}

}
