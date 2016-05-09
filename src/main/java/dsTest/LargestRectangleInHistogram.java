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
		// 在数组末尾加入一个0，方便后面操作
		int[] data = new int[height.length + 1];
		for (int i = 0; i < height.length; i++) {
			data[i] = height[i];
		}
		// 利用一个栈存储数组的递增索引序列
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		// 遍历每一个元素，如果栈空或者元素大于栈顶元素，就将元素如栈
		for (int i = 0; i < data.length; i++) {
			if (stack.isEmpty() || data[stack.peek()] < data[i]) {
				stack.push(i);
			} else {
				// 否则就持续出栈，直到栈顶元素小于当前元素
				while (!stack.isEmpty() && data[stack.peek()] > data[i]) {
					int j = stack.pop();
					// 对每一个出栈元素进行面积的计算
					//利用这个栈，可以保证栈顶元素对应值与下一个元素对应值之间所有的值都大于栈顶元素对应值，从而方便了面积的计算
					//如果栈空，说明当前下标以前所有的值都要比data[j]大，所以宽度直接取i
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
