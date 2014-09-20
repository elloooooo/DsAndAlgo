package dsTest;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
		//�洢��ʱ�ĺ�
		int sum = 0;
		//�洢���
		int res = 0;
		//����target����Ծ���
		int distence = Integer.MAX_VALUE;
		//ת��Ϊ2sum
		Arrays.sort(num);
		//��ȷ��һ��ֵ
		for (int i = 0; i < num.length; i++) {
			//ȥ�أ������ж�
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				sum = num[j] + num[k] + num[i];
				if (sum > target) {
					if (sum - target < distence) {
						distence = sum - target;
						res = sum;
					}
					k--;
				} else if (sum < target) {
					if (target - sum < distence) {
						distence = target - sum;
						res = sum;
					}
					j++;
				} else {
					return target;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] s = { 0, 0, 0 };
		ThreeSumClosest t = new ThreeSumClosest();
		int res = t.threeSumClosest(s, 1);
		System.out.println(res);

	}
}
