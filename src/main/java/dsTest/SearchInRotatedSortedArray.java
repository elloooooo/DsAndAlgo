package dsTest;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {

	public int search(int[] A, int target) {
		int minIndex = getMin(A);
		if(target==A[minIndex]){
			return minIndex;
		}
		int res = bsearch(A, minIndex, A.length-1, target);
		
		if(res==-1&&minIndex-1>=0){
			return bsearch(A, 0, minIndex-1, target);
		}else{
			return res;
		}
	}

	private int getMin(int[] A){
		int i = 0,j=A.length-1;
		int mid = (i+j)/2;
		
		if(A[mid]>=A[i]&&A[mid]<=A[j]){
			return i;
		}
		
		while(i+1<j){
			if(A[mid]<A[i]){
				j = mid;
				mid = (i+j)/2;
			}else{
				i = mid;
				mid = (i+j)/2;
			}
		}
		return j;
	}
	
	private int bsearch(int[] A,int begin,int end,int target){
		int i = begin,j=end, mid = (i+j)/2;
		if(A[i]==target){
			return i;
		}
		if(A[j]==target){
			return j;
		}
		
		while(i!=mid){
			if(A[mid]==target){
				return mid;
			}
			if(A[mid]<target){
				i = mid;
			}else{
				j = mid;
			}
			mid = (i+j)/2;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {3,1};
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int res = s.search(A, 3);
		System.out.println(res);
	}

}
