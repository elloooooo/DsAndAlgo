package dsTest;

import java.util.Stack;

/**
 * 将输入的数字字符串以8bit，BCD编码输出。 如果输入字符串的位数为奇数，则在最高位补零。
 * 
 * “1234” 4bit位表示： 0001 0010 0011 0100 BCD
 * 
 * 编码为 1 2 3 4
 * 
 * 若以8bit表示：0001 0010 0011 0100 BCD
 * 
 * 编码为 18 52
 * 
 * “123” 4bit位表示： 0001 0010 0011 BCD
 * 
 * 编码为 1 2 3
 * 
 * 若以8bit表示：0000 0001 0010 0011
 * 
 * BCD编码为 1 35
 * 
 * 例子： 输入：1234 输出：1852 输入: 123 输出：135
 */
public class BCDcode {

	public String transform(int x){
		Stack<Integer> stack = new Stack<Integer>();
		int elem = 0;
		while(x>0){
			int tmp = x%100;
			elem = tmp%10 + tmp/10*16;
			stack.push(elem);
			x /= 100;
		}
		StringBuffer sbf = new StringBuffer();
		while(!stack.isEmpty()){
			sbf.append(stack.pop().toString());
		}
		return sbf.toString();
	}
	public static void main(String[] args) {
		int t = 12341;
		BCDcode b = new BCDcode();
		System.out.println(b.transform(t));

	}

}
