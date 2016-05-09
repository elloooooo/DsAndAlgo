package dsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ��
 * b �� c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */
/**
 * @author Administrator
 * ת��Ϊ2sum����
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//����Ŷ������
		Arrays.sort(num);
		//�ó�ÿһ��ֵ*-1����Ϊ2sum��targetֵ
		for (int i = 0; i < num.length; i++) {
			//����һ��ֵ���������ֵ��ֻ��һ�����Ŷ����Ȼ���ظ�
			if(i!=0&&num[i]==num[i-1]){
				continue;
			}
			//һ�¾���2sum����
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				if (num[j] + num[k] == num[i] * (-1)) {
					List<Integer> _tmp = new ArrayList<Integer>();
					_tmp.add(num[i]);
					_tmp.add(num[j]);
					_tmp.add(num[k]);
					res.add(_tmp);
					//�����Ǳ����ظ�
					do {
						j++;
					} while (j<k&&num[j] == num[j - 1]);
					do {
						k--;
					} while (k>j&&num[k] == num[k + 1]);

				} else if (num[j] + num[k] > num[i] * (-1)) {
					k--;
				} else {
					j++;
				}
			}
		}
		return res;
	}
}
