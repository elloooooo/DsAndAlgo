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
	 * ��һ��
	 * ̰���㷨
	 * 
	 * step��ʾÿһ���������ƶ��ľ���
	 * ��һ���������ƶ�A[0]
	 * @param A
	 * @return
	 */
	public boolean canJump(int[] A) {
		int n = A.length;
		if (n == 0)
			return false;
		//��һ���������ƶ�A[0]
		int step = A[0];
		for (int i = 1; i < n; i++)
			//�����һ��ֻ�ƶ���һ����������ʱ�����ƶ��ľ����Ƿ��Զ
			if (step > 0) {
				step--;
				step = max(step, A[i]);
			} else
				//��������ƶ��ľ����Ѿ�������0���һ�û��������ĩβ��˵����ԶҲ��������
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
	 * ������
	 * ��̬�滮
	 * @param A
	 * @return
	 */
	public boolean canJump2(int[] A) {
		int n = A.length;
		//���Ե������Զ����
		int maxi;
		maxi = A[0];
		//���ÿ������������Ե������Զ���룬�������������ֵ����Ϊ�������̿��Ե������Զ����
		for (int i = 1; i < n - 1; i++) {
			//����ҪС�ģ���Ҫ���ĵ㣬һ���Ǵ�֮ǰ�����ĵ���������Ե���ĵ�
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
