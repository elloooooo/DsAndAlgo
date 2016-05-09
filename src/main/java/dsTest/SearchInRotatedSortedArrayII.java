package dsTest;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 */
/**
 * @author Administrator 改进的二分查找，充分利用数组中的顺序元素
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int begin = 0, end = A.length - 1;
		while (begin < end) {
			int mid = (begin + end) / 2;
			if (A[mid] == target) {
				return true;
			}

			if (A[mid] == A[begin]) {
				for (int i = begin; i < mid; i++)
					if (A[i] == target)
						return true;
				begin = mid + 1;
			} else if (A[mid] > A[begin]) {
				// begin-mid
				if (target >= A[begin] && target < A[mid]) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			} else {
				// mid-end
				if (A[mid] < target && target <= A[end])
					begin = mid + 1;
				else
					end = mid - 1;
			}
		}
		if (begin == end && A[begin] == target)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int[] data = { 1, 3, 5 };
		SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII();
		boolean res = s.search(data, 1);
		System.out.println(res);
	}

}
