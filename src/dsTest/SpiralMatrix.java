package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 */
/**
 * @author Administrator
 * 本题目的关键是各种边界条件的判断
 * 还有就是循环退出的条件
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int start = 0;
		int rows = matrix.length;
		List<Integer> res = new ArrayList<Integer>();
		if(rows==0)return res; 
		int cols = matrix[0].length;
		//循环退出的条件
		while(rows>start*2&&cols>start*2){
			res.addAll(printOneCircle(matrix,rows,cols,start));
			start++;
		}
		return res;
	}

	private List<Integer> printOneCircle(int[][] matrix, int rows, int cols, int start) {
		List<Integer> tmp = new ArrayList<Integer>();
		int endX = cols-1-start;
		int endY = rows-1-start;
		
		//从左向右打印
		for(int i=start;i<=endX;i++){
			tmp.add(matrix[start][i]);
		}
		//从上到下打印
		if(start<endY){
			for(int i=start+1;i<=endY;i++){
				tmp.add(matrix[i][cols-1-start]);
			}
		}
		//从右向左打印
		if(start<endX&&start<endY){
			for(int i=endX-1;i>=start;i--){
				tmp.add(matrix[rows-start-1][i]);
			}
		}
		//从下向上打印
		if(start<endX&&start<endY-1){
			for(int i=endY-1;i>=start+1;i--){
				tmp.add(matrix[i][start]);
			}
		}
		
		return tmp;
	}

	
	public String spiralOrderForTest(int[][] matrix){
		List<Integer> res = spiralOrder(matrix);
		StringBuffer sbf = new StringBuffer();
		for(Integer elem:res){
			sbf.append(elem);
			sbf.append(" ");
		}
		return sbf.toString().trim();
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] matrix = {};
		SpiralMatrix s = new SpiralMatrix();
		List<Integer> res = s.spiralOrder(matrix);
		for(Integer elem:res){
			System.out.println(elem);
		}
		
		System.out.println(s.spiralOrderForTest(matrix));
	}

}
