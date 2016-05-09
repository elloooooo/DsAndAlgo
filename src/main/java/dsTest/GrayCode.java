package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2
 */
/**
 * ��һ��ֱ�����ɸ����� Gray Code 0 = 0, ��һ����toggle���ұߵ�bit(LSB), ����һ����toggle���ұ�ֵΪ ��1��
 * bit�����һ��bit��Ȼ���ظ�
 * 
 * �磺 3bit
 * 
 * Gray Code: 000, 001, 011, 010, 110, 111, 101, 100, ���ұ�ֵΪ ��1�� ��bit��������ˣ�������
 * 
 * Binary : 000, 001, 010, 011, 100, 101, 110, 111
 * 
 * ������Binary Code ת��ΪGray Code�ˡ�
 * 
 * �磺Binary Code ��1011 Ҫת����Gray Code
 * 
 * 1011 = 1����д��һλ��, 1(��һλ��ڶ�λ��� 1^0 = 1), 1(�ڶ�λ������λ�� 0^1=1), 0 (1^1 =0) =1110
 * ��ʵ�͵��� (1011 >> 1) ^ 1011 = 1110
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		int max = (int) (Math.pow(2, n));
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < max; i++) {
			res.add(i ^ (i >> 1));
		}
		return res;
	}

	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		List<Integer> res = g.grayCode(2);
		for (Integer elem : res) {
			System.out.println(elem);
		}

	}

}
