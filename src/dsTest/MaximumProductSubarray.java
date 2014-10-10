package dsTest;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 */
/**
 * 因为数组中出现正数负数，所以我们需要记录到某个位置时的最大值与最小值，因为最小值可能在下一步乘以负数就变成最大值
 */
public class MaximumProductSubarray {
	public static int maxProduct(int[] A) {
		if (A.length < 1) {
			return 0;
		}
		int max_tmp = A[0];
		int min_tmp = A[0];
		int res = A[0];

		for (int i = 1; i < A.length; i++) {
			int a = max_tmp * A[i];
			int b = min_tmp * A[i];
			int c = A[i];
			max_tmp = Math.max(Math.max(a, b), c);
			min_tmp = Math.min(Math.min(a, b), c);
			res = max_tmp > res ? max_tmp : res;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] data = { -2 };
		int res = MaximumProductSubarray.maxProduct(data);
		System.out.println(res);

	}

}
