package others;

public class FindMaxString {
	/**
	 * 寻找跨越中点的最大字串
	 * 
	 * @param num
	 * @param low
	 * @param mid
	 * @param high
	 * @return Max_res 返回一个数组，数组包含最大字串的左下标，右下标，字串和
	 */
	private int[] findCrossMaxSubstring(int[] num, int low, int mid, int high) {
		int[] C_max_res = new int[3];
		int Lindex = 0;
		int Rindex = 0;
		int Lmax = -9999;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += num[i];
			if (sum > Lmax) {
				Lmax = sum;
				Lindex = i;
			}
		}
		int Rmax = -9999;
		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum += num[i];
			if (sum > Rmax) {
				Rmax = sum;
				Rindex = i;
			}
		}

		C_max_res[0] = Lindex;
		C_max_res[1] = Rindex;
		C_max_res[2] = Lmax + Rmax;

		return C_max_res;
	}

	/**
	 * 按照最大字串完全在左半一個字串中，完全在右半個字串中和跨越中點三種情況
	 * 
	 * @param num
	 * @param low
	 * @param high
	 * @return Max_res 返回一个数组，数组包含最大字串的左下标，右下标，字串和
	 */
	public int[] findMaxSubstring(int[] num, int low, int high) {
		int[] Max_res = new int[3];
		if (low == high) {
			Max_res[0] = low;
			Max_res[1] = high;
			Max_res[2] = num[low];
			return Max_res;
		} else {
			int mid = (low + high) / 2;
			// 如果MaxSubstring出现在low~mid

			int[] L_Max_res = findMaxSubstring(num, low, mid);

			// 如果MaxSubstring出现在mid~high
			int[] R_Max_res = findMaxSubstring(num, mid + 1, high);

			// 如果MaxSubstring跨mid
			int[] C_Max_res = findCrossMaxSubstring(num, low, mid, high);

			if (L_Max_res[2] > R_Max_res[2] && L_Max_res[2] > C_Max_res[2]) {
				Max_res = L_Max_res;
			} else if (R_Max_res[2] > L_Max_res[2]
					&& R_Max_res[2] > C_Max_res[2]) {
				Max_res = R_Max_res;
			} else if (C_Max_res[2] > L_Max_res[2]
					&& C_Max_res[2] > R_Max_res[2]) {
				Max_res = C_Max_res;
			}
			return Max_res;
		}
	}

	/**
	 * 该方法使用动态规划的思想
	 * 原问题分解为寻找以每一个数为结尾的最大子串问题
	 * 而这些子问题之间有相互关联
	 * 知道A[n-1]为结尾的最大子串后，就可以在常熟时间内知道A[n]结尾的最大字串
	 * 最终取最大子串和最大的一个即可
	 * @param data
	 * @return
	 */
	public int[] findMaxString2(int[] data) {
		int[] res = new int [3];//存放结果：最大和，启始元素下标，结束元素下标
		int sum = 0;//存放以某一元素为结尾的最大字串的和值
		int max = -9999;//最大和的最大子串
		int from = 0;//起始元素下标
		int to = 0;//结束元素下标
		for (int i = 0; i < data.length; i++) {
			//每一次循环后sum为data[i]为结尾的最大子串和
			if (data[i] < sum + data[i]) {
				sum += data[i];
			} else {
				sum = data[i];
				from = i;
			}
			if(max<sum){
				max=sum;
				to = i;
			}
		}
		res[0] = from;
		res[1] = to;
		res[2] = max;
		return res;
	}
	
}
