package dsTest;

/**
 * 将字符串排序，排序优先级如：aAbBcC....zZ 计数排序变种
 *
 */
public class SumSort {
	public static void main(String[] args) {
		char[] testdata = { 'a', 'b', 'C', 'x', 'A', 'D' };
		char[] res = sort(testdata);
		for (char elem : res) {
			System.out.println(elem);
		}
	}

	public static char[] sort(char[] data) {
		int[] tmp = new int[52];
		for (int i = 0; i < data.length; i++) {
			if (data[i] >= 'a' && data[i] <= 'z') {
				tmp[(data[i] - 'a') * 2]++;
			} else if (data[i] >= 'A' && data[i] <= 'Z') {
				tmp[(data[i] - 'A') * 2 + 1]++;
			}
		}
		int index = 0;
		char[] res = new char[data.length];
		for (int i = 0; i < 52; i++) {
			if (tmp[i] != 0) {
				if (i % 2 == 0) {
					res[index++] = (char) (i / 2 + 'a');
				} else {
					res[index++] = (char) ((i - 1) / 2 + 'A');
				}
			}
		}

		return res;
	}
}
