package dsTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
 */

/**
 * @author Administrator
 * 动态规划思想
 * 
 * 
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		if(s.length()<0||dict.isEmpty()){
			return false;
		}
		//利用一个数组，每一位表示第i个字符为末尾字符的字串可以拆分为字典中的值
		boolean[] tmp = new boolean[s.length()+1];
		tmp[0] = true;
		
		for(int i=0;i<=s.length();i++){
			for(int j=0;j<i;j++){
				if(tmp[j]&&dict.contains(s.substring(j,i))){
					tmp[i] = true;
					break;
				}
			}
		}
        return tmp[s.length()];
    }
	
	public List<String> wordBreakII(String s, Set<String> dict) {
		if(s.length()<0||dict.isEmpty()){
			return null;
		}
		//利用一个数组，每一位表示第i个字符为末尾字符的字串可以拆分为字典中的值
		boolean[] tmp = new boolean[s.length()+1];
		tmp[0] = true;
		Map<Integer,List<Integer>> partionPoint = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<=s.length();i++){
			List<Integer> _partionPoint = new ArrayList<Integer>();
			for(int j=0;j<i;j++){
				if(tmp[j]&&dict.contains(s.substring(j,i))){
					tmp[i] = true;
					_partionPoint.add(j);
				}
				partionPoint.put(i, _partionPoint);
			}
		}
		for(int key=s.length()-1;key>=0;key--){
			if(partionPoint.get(key).size()>1){
				
			}
			
		}
        return null;
    }
	public static void main(String[] args) {
		String t = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");
		/*String t = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");*/
		/*String t = "cars";
		Set<String> dict = new HashSet<String>();
		dict.add("car");
		dict.add("ca");
		dict.add("rs");*/
		WordBreak wb = new WordBreak();
		/*boolean flag = wb.wordBreak(t,dict);*/
		wb.wordBreakII(t,dict);
	}

}
