package dsTest;

/**
 *Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *Each element in the array represents your maximum jump length at that position.
 *Determine if you are able to reach the last index.
 *
 *For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {

	/**
	 * 法一：
	 * 贪心算法
	 * 
	 * step表示每一次最多可以移动的距离
	 * 第一次最多可以移动A[0]
	 * @param A
	 * @return
	 */
	public boolean canJump(int[] A) {
		int n = A.length;
		if (n == 0)
			return false;
		//第一次最多可以移动A[0]
		int step = A[0];
		for (int i = 1; i < n; i++)
			//假如第一次只移动了一步，看看此时可以移动的距离是否更远
			if (step > 0) {
				step--;
				step = max(step, A[i]);
			} else
				//如果可以移动的距离已经不大于0，且还没到达序列末尾，说明永远也到不了了
				return false;

		return true;
	}

	private int max(int step, int i) {
		if (step > i) {
			return step;
		} else {
			return i;
		}
	}

	/**
	 * 法二：
	 * 动态规划
	 * @param A
	 * @return
	 */
	public boolean canJump2(int[] A) {
		int n = A.length;
		//可以到达的最远距离
		int maxi;
		maxi = A[0];
		//求出每个点出发，可以到达的最远距离，并保存其中最大值，作为整个过程可以到达的最远距离
		for (int i = 1; i < n - 1; i++) {
			//其中要小心，需要检测的点，一定是从之前检测过的点出发，可以到达的点
			if (maxi < i)
				return false;
			if (i + A[i] > maxi) {
				maxi = i + A[i];
			}
		}
		if (maxi >= n - 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 0, 4, 5 };
		JumpGame j = new JumpGame();
		System.out.println(j.canJump(a));
	}

}
