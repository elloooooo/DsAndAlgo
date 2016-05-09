package dsTest;

import java.util.Stack;

/**
 * ������������ַ�����8bit��BCD��������� ��������ַ�����λ��Ϊ�������������λ���㡣
 * 
 * ��1234�� 4bitλ��ʾ�� 0001 0010 0011 0100 BCD
 * 
 * ����Ϊ 1 2 3 4
 * 
 * ����8bit��ʾ��0001 0010 0011 0100 BCD
 * 
 * ����Ϊ 18 52
 * 
 * ��123�� 4bitλ��ʾ�� 0001 0010 0011 BCD
 * 
 * ����Ϊ 1 2 3
 * 
 * ����8bit��ʾ��0000 0001 0010 0011
 * 
 * BCD����Ϊ 1 35
 * 
 * ���ӣ� ���룺1234 �����1852 ����: 123 �����135
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
