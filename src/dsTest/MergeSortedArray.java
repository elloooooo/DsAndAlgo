package dsTest;
/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 */
/**
 * @author Administrator
 *
 */
public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {
		//���B����û��Ԫ�أ�ʲô�����ɣ�ֱ�ӷ���
		if(n==0){
			return;
		}
		//���A����û��Ԫ�أ���ô��i��ʼ��Ϊ0��������ж���A[i]��ԶС��B[j]��һֱ�������ѭ�����൱�ڰ�B���Ƶ�A�У���Ȼ���Ǽ���B������ֵ��Ϊ����
		int i=(m==0)?0:m-1,j=n-1,index = m+n-1;
		while(i>=0&&j>=0){
			if(A[i]>B[j]){
				A[index] = A[i];
				i--;
				index--;
			}else{
				A[index] = B[j];
				j--;
				index--;
			}
		}
		//���Bû�����꣬��A�����ˣ��Ǿ�Ҫ��B��ʣ�µ�Ԫ�طŵ�A��
		if(j!=-1){
			while(j>=0){
				A[j] = B[j];
				j--;
			}
		}
		
	}

	public static void main(String[] args) {
		MergeSortedArray m = new MergeSortedArray();
		int[] A = new int[9];
		A[0]=2;
		int[] B = {1};
		m.merge(A, 1, B, 1);
		for(int i=0;i<A.length;i++){
			System.out.println(A[i]);
		}
	}

}
