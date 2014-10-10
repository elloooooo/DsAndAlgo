package dsTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * �ҳ���һ���������ε��ַ�
 */
public class FindFirstDuplicatChar {
	public char find(String str){
		char[] charArray = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		
		for(int i=0;i<charArray.length;i++){
			if(!set.contains(charArray[i])){
				set.add(charArray[i]);
			}else{
				return charArray[i];
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String str = "qywyer23tdd";
		FindFirstDuplicatChar f = new FindFirstDuplicatChar();
		System.out.println(f.find(str));
	}

}
