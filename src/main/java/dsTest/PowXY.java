package dsTest;


public class PowXY {
	/**
	 * ��x��Y�η� �����3λ��
	 */
	public long ytimesxLast3Digits(long x, long y) {
		long res = 0;
		if (y == 0)
			return 1;
		if (y == 1)
			return x;
		long temp = ytimesxLast3Digits(x, y / 2);
		if (temp > 1000) {
			temp %= 1000;
		}
		res = y % 2 == 0 ? temp * temp : temp * temp * x;
		res %= 1000;
		return res;
	}

	/**
	 * @param x
	 * @param n
	 * @return
	 * ��x��n�η���ע��n�п����Ǹ���
	 */
	public double pow(double x, int n) {
		double tmp = ytimesx(x, Math.abs(n));
		if (n > 0) {
			return tmp;
		} else {
			return 1 / tmp;
		}

	}

	private double ytimesx(double x, int y) {
		double res = 0;
		if (y == 0)
			return 1;
		if (y == 1)
			return x;
		//����λ����/2
		double temp = ytimesx(x, y >> 1);
		//&1����%2���ж�����ż��
		res = (y & 1) == 0 ? temp * temp : temp * temp * x;

		return res;
	}

	public static void main(String[] args) {
		// long x = 2, y = 100;
		// PowXY p = new PowXY();
		// System.out.println(Long.MAX_VALUE);
		// System.out.println((long)Math.pow(x, y));
		// System.out.println(p.ytimesxLast3Digits(x, y));

		double x = 4;
		int n = 2;
		PowXY p = new PowXY();
		double res = p.pow(x, n);
		System.out.println(res);

	}

}
