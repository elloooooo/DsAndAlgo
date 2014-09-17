package dsTest;

import java.util.Stack;

/**
 *  Given an input string, reverse the string word by word.
 *	For example,
 *	Given s = "the sky is blue",
 *	return "blue is sky the".
 *	
 *	click to show clarification.
 *	
 *	Clarification:
 *	What constitutes a word?
 *		A sequence of non-space characters constitutes a word.
 *	Could the input string contain leading or trailing spaces?
 *		Yes. However, your reversed string should not contain leading or trailing spaces.
 *	How about multiple spaces between two words?
 *		Reduce them to a single space in the reversed string.
 *
 */
public class ReverseWordsInString {

	public String reverseWords(String s) {
		//取出开头和结尾的空格
		s = s.trim();
		char[] data = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < data.length; i++) {
			//第一次全体如栈时，如果有连续的空格，只入栈一个
			if (!stack.isEmpty() && stack.peek() == 32 && data[i] == 32) {
				continue;
			}
			stack.push(data[i]);
		}
		//全部弹出，是整个字符串反转
		int j = 0;
		char[] _data = new char[stack.size()];
		while (!stack.isEmpty()) {
			_data[j] = stack.pop();
			j++;
		}

		StringBuffer stringBuffer = new StringBuffer();
		//第二次入栈
		for (int i = 0; i < _data.length; i++) {
			//不是空格的话，就入栈
			if (_data[i] != 32) {
				stack.push(_data[i]);
				//如果如栈元素是最后一个元素，全部出栈
				if (i == _data.length - 1) {
					while (!stack.isEmpty()) {
						stringBuffer.append(stack.pop());
					}
				}
			} else {
				//如果是空格，就全部出栈
				while (!stack.isEmpty()) {
					stringBuffer.append(stack.pop());
				}
				//空格直接进入stringBuffer
				stringBuffer.append(_data[i]);
			}
		}

		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		String s = " a    b  ";
		ReverseWordsInString r = new ReverseWordsInString();
		System.out.println(r.reverseWords(s));

	}

}
