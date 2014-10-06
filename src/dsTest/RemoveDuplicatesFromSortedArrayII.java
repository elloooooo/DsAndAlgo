package dsTest;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {

	public static int removeDuplicates(int[] A) {
		if(A.length==0){
			return 0;
		}
		if(A.length==1){
			return 1;
		}
		int index = 1;
		//�ظ�����
		int dupCount = 0;
		for(int i=1;i<A.length;i++){
			if(A[i]==A[i-1]){
				//�ظ��������ڻ����2����ʡȥ������
				if(++dupCount>=2){
					continue;
				}else{
					//�ظ�һ����������
					A[index++] = A[i];
				}
			}else{
				//���ظ�����������dupCount����
				A[index++] = A[i];
				dupCount = 0;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] data = {1,2,2,2,3,3,5};
		int res = RemoveDuplicatesFromSortedArrayII.removeDuplicates(data);
		System.out.println(res);
	}

}
