package dsTest;

/**
 * ��ָoffer ����һ�����ֶ����Ʊ�ʾ��1�ĸ���
 */
public class CountOneInBinaryNum {
	/**
	 * @param num
	 * @return
	 * ��һ�ⷨ�����������ƣ�ÿ�ζ�ȥ�ж��������ұ������Ƿ�Ϊ1
	 * �����������Ϊ���������ƺ�������÷���λ���㣬������ѭ��
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
	 * �������������֣���������flag����������ѭ����Σ��
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
	 * (num-1)&num����ʹnum�����Ʊ�ʾ�����ұߵ�1���0
	 * ����num���Ծ��ܼ��������Ĳ������ͻ��м���1
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
