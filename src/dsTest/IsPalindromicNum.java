package dsTest;

/**
 * 判断一个数字是否是回文数
 *
 */
public class IsPalindromicNum {
	public boolean isPalindromNum(int num){
		Integer _num = new Integer(num);
		char[] array = _num.toString().toCharArray();
		int i=0;
		int j=array.length-1;
		while(i<j){
			if(array[i]!=array[j]){
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
	public boolean isPalindromNum2(int num){
		int pal = 0;
		int origin = num;
		while(num!=0){
			pal*=10;
			pal+=num%10;
			num/=10;
		}
		
		return pal==origin;
	}
	
	public static void main(String[] args) {
		int n = 12345321;
		IsPalindromicNum p = new IsPalindromicNum();
		System.out.println(p.isPalindromNum2(n));

	}

}
