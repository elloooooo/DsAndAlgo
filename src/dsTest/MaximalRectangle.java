package dsTest;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 */
/**
 * @author Administrator
 * 本题的思路是将题目转化为求条形图中最大的矩形问题
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		//dp[i][j]表示matrix数组中从第i行，第j列那个元素向上看，有多少个连续的1
		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0) {
					//第一行按照matrix初始化为1或者0；
					dp[i][j] = matrix[i][j] - '0';
				} else {
					//以后每行，如果该元素为1，则值为上面一个元素值+1，否则为0
					if (matrix[i][j] == '1') {
						dp[i][j] = dp[i - 1][j] + 1;
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			//将问题转化为求每一行上面的条形图中最大的矩形问题
			int tmp = largest(dp[i]);
			max = max > tmp ? max : tmp;
		}
		return max;
	}
	//该方法同求条形图中最大矩形那一题
	private int largest(int[] dp) {
		int[] _data = new int[dp.length + 1];
		for (int i = 0; i < dp.length; i++) {
			_data[i] = dp[i];
		}
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		while (i < _data.length) {
			if (stack.isEmpty() || _data[stack.peek()] < _data[i]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				int s = _data[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				max = max > s ? max : s;
			}
		}
		return max;
	}
}
