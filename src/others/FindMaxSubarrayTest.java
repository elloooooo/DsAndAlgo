package others;

public class FindMaxSubarrayTest {
	public static void main(String[] args){
        int[] res = new int[3];
        int[] test_num = {1,-2,-5,4,-1,7,9,-10,6,-3};
        int low = 0;
        int high = test_num.length-1;
        
		FindMaxString findMaxString = new FindMaxString();
		res = findMaxString.findMaxSubstring(test_num, low, high);
		System.out.println("从左起第："+(res[0]+1)+"个元素");
		System.out.println("到第："+(res[1]+1)+"个元素");
		System.out.println("最大和："+res[2]);
		
		int[] res2 = findMaxString.findMaxString2(test_num);
		System.out.println("from："+res2[0]);
		System.out.println("to："+res2[1]);
		System.out.println("最大和："+res2[2]);
	}

}
