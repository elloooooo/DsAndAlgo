package dsTest;

import util.SortUtil;


/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space? Have
 * you been asked this question in an interview?
 */
public class SortColors {
	public void sortColors(int[] A) {
		int i=0,j=0,k=A.length-1;
		while(i<A.length&&j<k){
			switch (A[i]) {
			case 0:
				if(i==0||i==j){
					i++;
				}else{
					SortUtil.exch(A, i, j);
				}
				j++;
				break;
			case 2:
				if(i>=k){
					return;
				}
				SortUtil.exch(A, i, k);
				k--;
				break;
			case 1:
				i++;
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = {0,0,1,0,1,1};
		SortColors s = new SortColors();
		s.sortColors(A);
		int i =0;
		while(i<A.length){
			System.out.println(A[i]);
			i++;
		}

	}

}