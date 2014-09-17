package dsTest;

import java.util.Stack;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	/**
	 * @param s
	 * @return
	 * ������ջ��ջȥ�������ֺ���ĸ�ַ�
	 * ����stringBuffer.reverse()���ַ�����ת
	 */
	public boolean isPalindrome(String s) {
		if(s==null||s.length()==0){
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		s = s.toLowerCase();
		char tmp = 0;
		for(int i=0;i<s.length();i++){
			tmp = s.charAt(i);
			if((tmp>='a'&&tmp<='z')||(tmp>='0'&&tmp<='9')){
				stack.push(tmp);
			}
		}
		StringBuffer sbf = new StringBuffer();
		while(!stack.isEmpty()){
			sbf.append(stack.pop());
		}
		
		return sbf.toString().equals(sbf.reverse().toString());
	}

	
	/**
	 * @param s
	 * @return
	 * ��������ȥ����Ч�ַ�
	 * �����ַ�����λ�ȶԣ�ȷ���Ƿ�Ϊ�����ִ�
	 */
	public boolean isPalindrome2(String s) {
		if(s==null||s.length()==0){
			return true;
		}
		s = s.toLowerCase();
		s = s.replaceAll("[^0-9a-z]", "");
		int head = 0,tail = s.length()-1;
		while(head<tail){
			if(s.charAt(head)!=s.charAt(tail)){
				return false;
			}
			head++;
			tail--;
		}
		
		return true;
	}
	
	/**
	 * @param s
	 * @return
	 * 
	 * ǰ���ֵĽ��
	 */
	public boolean isPalindrome3(String s) {
		if(s==null||s.length()==0){
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		s = s.toLowerCase();
		char tmp = 0;
		for(int i=0;i<s.length();i++){
			tmp = s.charAt(i);
			if((tmp>='a'&&tmp<='z')||(tmp>='0'&&tmp<='9')){
				stack.push(tmp);
			}
		}
		StringBuffer sbf = new StringBuffer();
		while(!stack.isEmpty()){
			sbf.append(stack.pop());
		}
		s = sbf.toString();
		int head = 0,tail = s.length()-1;
		while(head<tail){
			if(s.charAt(head)!=s.charAt(tail)){
				return false;
			}
			head++;
			tail--;
		}
		
		return true;
	}

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
//		String str = ".a";
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome3(str));
	}

}
