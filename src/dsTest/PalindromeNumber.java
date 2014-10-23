package dsTest;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * ���������ת�����ַ������бȽϵĻ���һ����ʹ�ö���Ĵ洢�ռ䣬��������ֽ��з�ת���п��ܳ��ִ������⣬����ת����������
 * �𰸣�ÿ��ȡ�����ֵ����λ�����λ�����бȽ�
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		//������overflow�����ֶ�����false
		if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE || x < 0) {
			return false;
		}
		//��Ϊ��������121������100��11������10
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
