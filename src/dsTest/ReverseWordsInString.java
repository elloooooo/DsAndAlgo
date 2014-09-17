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
		//ȡ����ͷ�ͽ�β�Ŀո�
		s = s.trim();
		char[] data = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < data.length; i++) {
			//��һ��ȫ����ջʱ������������Ŀո�ֻ��ջһ��
			if (!stack.isEmpty() && stack.peek() == 32 && data[i] == 32) {
				continue;
			}
			stack.push(data[i]);
		}
		//ȫ���������������ַ�����ת
		int j = 0;
		char[] _data = new char[stack.size()];
		while (!stack.isEmpty()) {
			_data[j] = stack.pop();
			j++;
		}

		StringBuffer stringBuffer = new StringBuffer();
		//�ڶ�����ջ
		for (int i = 0; i < _data.length; i++) {
			//���ǿո�Ļ�������ջ
			if (_data[i] != 32) {
				stack.push(_data[i]);
				//�����ջԪ�������һ��Ԫ�أ�ȫ����ջ
				if (i == _data.length - 1) {
					while (!stack.isEmpty()) {
						stringBuffer.append(stack.pop());
					}
				}
			} else {
				//����ǿո񣬾�ȫ����ջ
				while (!stack.isEmpty()) {
					stringBuffer.append(stack.pop());
				}
				//�ո�ֱ�ӽ���stringBuffer
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
