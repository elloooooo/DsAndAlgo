package others;

public class FindMaxSubarrayTest {
	public static void main(String[] args){
        int[] res = new int[3];
        int[] test_num = {1,-2,-5,4,-1,7,9,-10,6,-3};
        int low = 0;
        int high = test_num.length-1;
        
		FindMaxString findMaxString = new FindMaxString();
		res = findMaxString.findMaxSubstring(test_num, low, high);
		System.out.println("������ڣ�"+(res[0]+1)+"��Ԫ��");
		System.out.println("���ڣ�"+(res[1]+1)+"��Ԫ��");
		System.out.println("���ͣ�"+res[2]);
		
		int[] res2 = findMaxString.findMaxString2(test_num);
		System.out.println("from��"+res2[0]);
		System.out.println("to��"+res2[1]);
		System.out.println("���ͣ�"+res2[2]);
	}

}
