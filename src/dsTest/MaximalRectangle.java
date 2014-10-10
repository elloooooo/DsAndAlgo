package dsTest;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 */
/**
 * @author Administrator
 * �����˼·�ǽ���Ŀת��Ϊ������ͼ�����ľ�������
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		//dp[i][j]��ʾmatrix�����дӵ�i�У���j���Ǹ�Ԫ�����Ͽ����ж��ٸ�������1
		int[][] dp = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0) {
					//��һ�а���matrix��ʼ��Ϊ1����0��
					dp[i][j] = matrix[i][j] - '0';
				} else {
					//�Ժ�ÿ�У������Ԫ��Ϊ1����ֵΪ����һ��Ԫ��ֵ+1������Ϊ0
					if (matrix[i][j] == '1') {
						dp[i][j] = dp[i - 1][j] + 1;
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			//������ת��Ϊ��ÿһ�����������ͼ�����ľ�������
			int tmp = largest(dp[i]);
			max = max > tmp ? max : tmp;
		}
		return max;
	}
	//�÷���ͬ������ͼ����������һ��
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
