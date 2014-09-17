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
 * 法一：直接生成格雷码 Gray Code 0 = 0, 下一项是toggle最右边的bit(LSB), 再下一项是toggle最右边值为 “1”
 * bit的左边一个bit。然后重复
 * 
 * 如： 3bit
 * 
 * Gray Code: 000, 001, 011, 010, 110, 111, 101, 100, 最右边值为 “1” 的bit在最左边了，结束。
 * 
 * Binary : 000, 001, 010, 011, 100, 101, 110, 111
 * 
 * 法二：Binary Code 转换为Gray Code了。
 * 
 * 如：Binary Code ：1011 要转换成Gray Code
 * 
 * 1011 = 1（照写第一位）, 1(第一位与第二位异或 1^0 = 1), 1(第二位异或第三位， 0^1=1), 0 (1^1 =0) =1110
 * 其实就等于 (1011 >> 1) ^ 1011 = 1110
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
