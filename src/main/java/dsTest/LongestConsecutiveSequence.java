package dsTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */

/**
 * @author Administrator
 * �����뵽Ҫ���򣬵��������㷨һ���Ǹ�n*log(n)���㷨
 * ���ǽ��������hash������һ������ǰ����ߺ���һ�����Ƿ������hash�У��ҹ������־�hash�д�ɾ�� 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}

		int max = 0;
		for (int j = 0; j < num.length; j++) {
			int val = num[j];
			//�������hash�У�˵���Ѿ��ҹ���
			if (!set.contains(num[j])) {
				continue;
			}
			int tmpMax = 1;
			//�������������Ƿ������hash��
			while (set.contains(++val)) {
				set.remove(val);
				tmpMax++;
			}
			val = num[j];
			//�����ǰ������Ƿ������hash��
			while (set.contains(--val)) {
				set.remove(val);
				tmpMax++;
			}
			max = tmpMax > max ? tmpMax : max;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] t = { 100, 4, 200, 1, 3, 2 };
		// int[] t = new int[1];
		LongestConsecutiveSequence l = new LongestConsecutiveSequence();
		int maxlength = l.longestConsecutive(t);
		System.out.println(maxlength);
	}

}
