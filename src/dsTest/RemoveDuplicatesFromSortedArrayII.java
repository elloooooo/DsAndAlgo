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
		//重复次数
		int dupCount = 0;
		for(int i=1;i<A.length;i++){
			if(A[i]==A[i-1]){
				//重复次数等于或大于2，则省去不计数
				if(++dupCount>=2){
					continue;
				}else{
					//重复一个则参与计数
					A[index++] = A[i];
				}
			}else{
				//不重复则参与计数且dupCount清零
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
