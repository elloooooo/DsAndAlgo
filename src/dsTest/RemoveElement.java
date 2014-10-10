package dsTest;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 */
public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		int index=0;
		for(int i=0;i<A.length;i++){
			if(A[i]!=elem){
				A[index++] = A[i];
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,7,7};
		int res = RemoveElement.removeElement(data, 7);
		System.out.println(res);
	}

}
