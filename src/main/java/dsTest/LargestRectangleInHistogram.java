package dsTest;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		// ������ĩβ����һ��0������������
		int[] data = new int[height.length + 1];
		for (int i = 0; i < height.length; i++) {
			data[i] = height[i];
		}
		// ����һ��ջ�洢����ĵ�����������
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		// ����ÿһ��Ԫ�أ����ջ�ջ���Ԫ�ش���ջ��Ԫ�أ��ͽ�Ԫ����ջ
		for (int i = 0; i < data.length; i++) {
			if (stack.isEmpty() || data[stack.peek()] < data[i]) {
				stack.push(i);
			} else {
				// ����ͳ�����ջ��ֱ��ջ��Ԫ��С�ڵ�ǰԪ��
				while (!stack.isEmpty() && data[stack.peek()] > data[i]) {
					int j = stack.pop();
					// ��ÿһ����ջԪ�ؽ�������ļ���
					//�������ջ�����Ա�֤ջ��Ԫ�ض�Ӧֵ����һ��Ԫ�ض�Ӧֵ֮�����е�ֵ������ջ��Ԫ�ض�Ӧֵ���Ӷ�����������ļ���
					//���ջ�գ�˵����ǰ�±���ǰ���е�ֵ��Ҫ��data[j]�����Կ��ֱ��ȡi
					int s = data[j] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
					maxArea = maxArea > s ? maxArea : s;
				}
				stack.push(i);
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 4, 2, 0, 3, 2, 5 };
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		int res = l.largestRectangleArea(height);
		System.out.println(res);
	}

}
