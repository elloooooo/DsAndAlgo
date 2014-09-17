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
		//如果B里面没有元素，什么都不干，直接返回
		if(n==0){
			return;
		}
		//如果A里面没有元素，那么将i初始化为0，后面的判断中A[i]永远小于B[j]，一直走下面的循环；相当于把B复制到A中；当然这是假设B中所有值都为正数
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
		//如果B没有用完，而A用完了，那就要把B中剩下的元素放到A中
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
