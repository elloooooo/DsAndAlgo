package dsTest;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * 分析：如果转化成字符串进行比较的话，一定会使用额外的存储空间，如果将数字进行反转，有可能出现大数问题，即反转后的数字溢出
 * 答案：每次取出数字的最高位和最低位，进行比较
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		//负数和overflow的数字都返回false
		if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE || x < 0) {
			return false;
		}
		//作为基数，如121，基数100；11，基数10
		int base = 1;
		int tmp = x;
		while (tmp >= 10) {
			base *= 10;
			tmp /= 10;
		}

		while (base > 0) {
			if (x / base % 10 == x % 10) {
				x = x / 10;
				base /= 100;
				continue;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(1001));

	}

}
