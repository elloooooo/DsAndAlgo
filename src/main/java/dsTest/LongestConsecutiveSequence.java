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
 * 首先想到要排序，但是排序算法一定是个n*log(n)的算法
 * 考虑将数组存入hash表，查找一个数的前面或者后面一个数是否包含在hash中，找过的数字就hash中从删除 
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
			//如果不在hash中，说明已经找过了
			if (!set.contains(num[j])) {
				continue;
			}
			int tmpMax = 1;
			//这个数后面的数是否存在在hash中
			while (set.contains(++val)) {
				set.remove(val);
				tmpMax++;
			}
			val = num[j];
			//这个数前面的数是否存在在hash中
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
