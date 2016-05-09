package dsTest;

/**
 * 剑指offer 计算一个数字二进制表示中1的个数
 */
public class CountOneInBinaryNum {
	/**
	 * @param num
	 * @return
	 * 这一解法，将数字右移，每次都去判断数字最右边数字是否为1
	 * 如果输入数字为负数，右移后会左侧会用符号位补足，将会死循环
	 */
	public static int count0(int num){
		int count = 0;
		while(num!=0){
			if((num&1)!=0){
				count++;
			}
			count = count>>1;
		}
		return count;
	}
	/**
	 * @param num
	 * @return
	 * 不右移输入数字，而是左移flag，消除了死循环的危险
	 */
	public static int count1(int num){
		int count = 0;
		int flag = 1;
		while(flag!=0){
			if((num&flag)!=0){
				count++;
			}
			flag = flag<<1;
		}
		return count;
	}
	/**
	 * @param num
	 * @return
	 * (num-1)&num可以使num二进制表示中最右边的1变成0
	 * 所以num可以经受几次这样的操作，就会有几个1
	 */
	public static int count2(int num){
		int count =0;
		while(num!=0){
			count++;
			num = (num-1)&num;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(CountOneInBinaryNum.count2(9));
	}

}
