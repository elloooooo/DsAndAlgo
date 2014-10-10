package dsTest;

/**
 * ��ָoffer
 * ��������n����˳���ӡ����1������nλʮ��������
 * ��������3����ӡ1��2��3��...,999
 *
 * �����Ǹ��������⣬���ַ�����ʾ���ִ���
 * ��������nλ0-9��ȫ����
 */
public class PrintToMaxOfDigits {
	public static void printToMaxOfDigits(int n){
		char[] numbers = new char[n];
		//��һλ�ֱ�Ϊ0-9�����ÿһ����������������
		for(int i=0;i<10;i++){
			numbers[0] = (char) (i +'0');
			dfs(numbers,n,1);
		}
	}
	
	private static void dfs(char[] numbers, int n, int index) {
		if(index==n){
			print(numbers);
			return;
		}
		for(int i=0;i<10;i++){
			numbers[index] = (char) (i+'0');
			dfs(numbers,n,index+1);
		}
	}

	private static void print(char[] numbers) {
		//ǰ׺��0����ӡ
		boolean isBeginWithZero = true;
		StringBuffer sbf = new StringBuffer();
		for(int i=0;i<numbers.length;i++){
			if(isBeginWithZero&&numbers[i]!='0'){
				isBeginWithZero = false;
			}
			if(!isBeginWithZero){
				sbf.append(numbers[i]);
			}
		}
		System.out.println(sbf.toString());
	}

	public static void main(String[] args) {
		PrintToMaxOfDigits.printToMaxOfDigits(2);
	}

}
