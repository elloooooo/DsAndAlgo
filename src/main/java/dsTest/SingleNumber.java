package dsTest;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */

/**
 * @author Administrator
 * 异或运算，任何数字与自己异或为零
 * 
 * 数组中重复的元素在异或后就会消失，只剩下单数个的数字
 * 
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int x = 0;
		for (int i = 0; i < A.length; i++) {
			x ^= A[i];
		}
		return x;
	}
	
	/*
	 * Given an array of integers, every element appears three times except for
	 * one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 * 
	 * Answer:
	 * 
	 * 利用一个32位的数组，每一位用于统计该位上1的个数，出现过3次的数字所使用的位，1的个数一定为3的整数倍
	 * 
	 * 所以最后只要将mod3不为零的位数上置1，形成的数字就是只出现过一次的
	 * 
	 * PS.如果将mod3为2的位数置1，形成的则是出现过两次的数字
	 */
	public int singleNumberII(int[] A) {
		int x =0;
		int[] tmp = new int[32];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<32;j++){
				tmp[j] += ((1<<j)&A[i])!=0?1:0;
			}
		}
		
		for(int i=0;i<tmp.length;i++){
			if(tmp[i]%3!=0){
				x += 1<<i;
			}
		}
		
        return x;
    }
	public static void main(String[] args) {
		int[] t = {2,2,3,2};
		SingleNumber s = new SingleNumber();
		int x = s.singleNumberII(t);
		System.out.println(x);
	}

}
