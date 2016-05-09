package dsTest;

/**
 * 剑指offer
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。
 * 比如输入3，打印1，2，3，...,999
 *
 * 本题是个大数问题，用字符串表示数字处理
 * 就是生成n位0-9的全排列
 */
public class PrintToMaxOfDigits {
	public static void printToMaxOfDigits(int n){
		char[] numbers = new char[n];
		//第一位分别为0-9，针对每一种情况深度优先搜索
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
		//前缀的0不打印
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
