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
 * ������㣬�κ��������Լ����Ϊ��
 * 
 * �������ظ���Ԫ��������ͻ���ʧ��ֻʣ�µ�����������
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
	 * ����һ��32λ�����飬ÿһλ����ͳ�Ƹ�λ��1�ĸ��������ֹ�3�ε�������ʹ�õ�λ��1�ĸ���һ��Ϊ3��������
	 * 
	 * �������ֻҪ��mod3��Ϊ���λ������1���γɵ����־���ֻ���ֹ�һ�ε�
	 * 
	 * PS.�����mod3Ϊ2��λ����1���γɵ����ǳ��ֹ����ε�����
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
