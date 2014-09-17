package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [ [".Q..", "...Q", "Q...", "..Q."],// Solution 1
 * 
 * ["..Q.","Q...", "...Q", ".Q.."] ] // Solution 2
 */
public class NQueens {
	private List<int[]> solutions;
	public List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
		if (n == 0) {
			return res;
		}

		int[] queens = new int[n];
		for (int i = 0; i < n; i++) {
			queens[i] = i;
		}
		solutions = new ArrayList<int[]>();

		int[] solution = new int[n];

		permutation(queens, 0, solution);

		res = generateSolutionsGraph(solutions);
		return res;
	}

	private List<String[]> generateSolutionsGraph(List<int[]> solutions) {
		List<String[]> res = new ArrayList<String[]>();

		int len = solutions.get(0).length;

		for (int rows = 0; rows < solutions.size(); rows++) {
			String[] _solution = new String[len];
			
			for(int j=0;j<len;j++){
				StringBuffer sbf = new StringBuffer();
				for (int i = 0; i < len; i++) {
					if (i == solutions.get(rows)[j]) {
						sbf.append("Q");
					}else{
						sbf.append(".");
					}
				}
				_solution[j] = sbf.toString();
			}
			
			
			res.add(_solution);
		}

		return res;
	}

	private void permutation(int[] queens, int begin, int[] solution) {
		if (begin < queens.length) {
			for (int i = begin; i < queens.length; i++) {
				int tmp = queens[i];
				queens[i] = queens[begin];
				queens[begin] = tmp;

				solution[begin] = queens[begin];
				permutation(queens, begin + 1, solution);

				tmp = queens[begin];
				queens[begin] = queens[i];
				queens[i] = tmp;
			}
		} else {
			solutions.add(solution.clone());
		}

	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<String[]> res = nq.solveNQueens(3);
	}

}
