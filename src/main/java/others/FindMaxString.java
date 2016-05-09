package others;

public class FindMaxString {
	/**
	 * Ѱ�ҿ�Խ�е������ִ�
	 * 
	 * @param num
	 * @param low
	 * @param mid
	 * @param high
	 * @return Max_res ����һ�����飬�����������ִ������±꣬���±꣬�ִ���
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
	 * ��������ִ���ȫ�����һ���ִ��У���ȫ���Ұ낀�ִ��кͿ�Խ���c���N��r
	 * 
	 * @param num
	 * @param low
	 * @param high
	 * @return Max_res ����һ�����飬�����������ִ������±꣬���±꣬�ִ���
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
			// ���MaxSubstring������low~mid

			int[] L_Max_res = findMaxSubstring(num, low, mid);

			// ���MaxSubstring������mid~high
			int[] R_Max_res = findMaxSubstring(num, mid + 1, high);

			// ���MaxSubstring��mid
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
	 * �÷���ʹ�ö�̬�滮��˼��
	 * ԭ����ֽ�ΪѰ����ÿһ����Ϊ��β������Ӵ�����
	 * ����Щ������֮�����໥����
	 * ֪��A[n-1]Ϊ��β������Ӵ��󣬾Ϳ����ڳ���ʱ����֪��A[n]��β������ִ�
	 * ����ȡ����Ӵ�������һ������
	 * @param data
	 * @return
	 */
	public int[] findMaxString2(int[] data) {
		int[] res = new int [3];//��Ž�������ͣ���ʼԪ���±꣬����Ԫ���±�
		int sum = 0;//�����ĳһԪ��Ϊ��β������ִ��ĺ�ֵ
		int max = -9999;//���͵�����Ӵ�
		int from = 0;//��ʼԪ���±�
		int to = 0;//����Ԫ���±�
		for (int i = 0; i < data.length; i++) {
			//ÿһ��ѭ����sumΪdata[i]Ϊ��β������Ӵ���
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
