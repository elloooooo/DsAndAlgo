package dsTest;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 */
/**
 * @author Administrator
 * 利用动态规划思想
 * 首先假设dp[i]表示序列s[0]~s[i]子序列和的最大值，但是发现dp[i+1]与dp[i]之间的关系难以建立
 * 所以重新假设dp[i]表示，以第i个元素为结尾的序列的和最大值
 * 发现如果dp[i]已知的情况下，很容易求得dp[i+1]
 * 最后dp数组中保存着以各个数字为结尾的子序列和最大值
 * 取其中最大的即可
 */
public class MaximumSubarray {
	
	public int maxSubArray(int[] A) {
		int[] dp = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			if (dp[i] >= 0) {
				dp[i + 1] = dp[i] + A[i];
			} else {
				dp[i + 1] = A[i];
			}
		}

		return max(dp);
	}

	private int max(int[] dp) {
		int max = Integer.MIN_VALUE;
		//这里注意，因为dp[0]表示的是第0个元素为结尾的子序列的和最大值，是不存在的一种情况，
		//所以要选最值时要去掉这中情况
		for (int i = 1; i < dp.length; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		return max;
	}

	public static void main(String[] args) {
		// int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		int[] a = { -2 };
		MaximumSubarray m = new MaximumSubarray();
		int res = m.maxSubArray(a);
		System.out.println(res);
	}

}
