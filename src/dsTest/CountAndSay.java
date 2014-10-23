package dsTest;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {

	public String countAndSay(int n) {
		String seed = "1";
		for (int i = 1; i < n; i++) {
			seed = generateString(seed);
		}
		return seed;
	}

	private String generateString(String seed) {
		StringBuffer sbf = new StringBuffer();
		int num = 1;//���ַ����ִ�������
		//�����ַ���
		for (int index = 0; index < seed.length(); index++) {
			//�������һ��Ԫ���뵱ǰԪ����ͬ����num+1
			if (index + 1 < seed.length()
					&& seed.charAt(index) == seed.charAt(index + 1)) {
				num++;
				continue;
			}

			//�������ַ������ظ�ʱ������ǰ�ַ������뵱ǰ�ַ�����sbf
			sbf.append(num);
			sbf.append(seed.charAt(index));
			//��������1
			num = 1;
		}

		return sbf.toString();
	}

	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(25));

	}

}
