package dsTest;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 */
/**
 * @author Administrator
 * f(n)=f(n-1)+f(n-2)
 */
public class ClimbingStairs {

	public int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2)
			return n;
		int a = 1;
		int b = 2;
		int res = 0;
		while (n > 2) {
			res = a + b;
			a = b;
			b = res;
			n--;
		}
		return res;
	}

	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(3));

	}

}
