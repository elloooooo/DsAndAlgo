package dsTest;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 */
public class ReverseInteger {

	public int reverse(int x) {
		//�жϷ��ţ������ŵĴ���ͬ
		int flag = 1;
		if(x<0){
			x*=-1;
			flag = -1;
		}
		
		long tmp=0;
		while(x>0){
			tmp = tmp*10 + x%10;
			//��ֹreverse�����
			if(flag==1&&tmp>Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}else if(flag==-1&&tmp*flag<Integer.MIN_VALUE){
				return Integer.MIN_VALUE;
			}
			x /= 10;
		}
		
		return (int) (tmp*flag);
	}
}
