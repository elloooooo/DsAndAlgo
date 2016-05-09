package dsTest;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {
	private boolean flag;
	public boolean exist(char[][] board, String word) {
		//记录board里面的元素是否被访问过
		boolean[][] isRead = new boolean[board.length][board[0].length];
		//从每一个元素为起点，利用dfs搜索
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//如果以某一个元素为起点已搜索到了，就不进行下面的搜索了
				if(this.flag!=true){
					isRead[i][j] = true;
					dfs(board, i, j, word, 0, isRead);
					isRead[i][j] = false;
				}
			}
		}
		return flag;
	}

	private void dfs(char[][] board, int i, int j, String word, int k, boolean[][] isRead) {
		// 定义一个标准向量，分别对应向左，上，右，下方移动
		int[][] vector = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		char target = word.charAt(k);
		//当前节点字符相同，且本节点是最后字符串一个元素，搜索成功
		if (target == board[i][j]) {
			if (k == word.length() - 1) {
				this.flag = true;
				return;
			}
			//否则在4个方向上继续搜索
			for (int d = 0; d < 4; d++) {
				//如果已搜索到了，就不进行下面的搜索了
				if (this.flag == true) {
					return;
				}
				int nextRowIndex = i + vector[d][0];
				int nextColIndex = j + vector[d][1];
				if((nextRowIndex < 0 || nextRowIndex>= board.length ||nextColIndex < 0 || nextColIndex>= board[0].length)||isRead[nextRowIndex][nextColIndex]){
					continue;
				}else{
					isRead[nextRowIndex][nextColIndex] = true;
					dfs(board, nextRowIndex, nextColIndex, word, k + 1, isRead);
					isRead[nextRowIndex][nextColIndex] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		/*char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };*/
//		char[][] board = { { 'A', 'B' } };
		char[][] board = { { 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A' },
				{ 'A', 'A', 'A', 'A' } };
		WordSearch w = new WordSearch();
		String word = "AAAAAAAAAAAAA";
		boolean res = w.exist(board, word);
		System.out.println(res);
	}

}
