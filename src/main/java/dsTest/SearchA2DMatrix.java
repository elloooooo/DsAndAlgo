package dsTest;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7],
 * 
 * [10, 11, 16, 20],
 * 
 * [23, 30, 34, 50] ]
 * 
 * Given target = 3, return true.
 */
/**
 * @author Administrator
 * 这题的关键就是要从右上角的元素开始比较，即第一个元素（数组）的最后一个元素开始，
 * 因为如果target大于它，就可以排除一行
 */
public class SearchA2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int cols = matrix[0].length-1;
		int rows = 0;
		
		while(rows<matrix.length&&cols>=0){
			if(target==matrix[rows][cols]){
				return true;
			}else if(target>matrix[rows][cols]){
				rows++;
			}else{
				cols--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		int target = 4;
		SearchA2DMatrix s = new SearchA2DMatrix();
		boolean res = s.searchMatrix(matrix, target);
		System.out.println(res);

	}

}
