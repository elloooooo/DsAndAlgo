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
		//��¼board�����Ԫ���Ƿ񱻷��ʹ�
		boolean[][] isRead = new boolean[board.length][board[0].length];
		//��ÿһ��Ԫ��Ϊ��㣬����dfs����
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//�����ĳһ��Ԫ��Ϊ������������ˣ��Ͳ����������������
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
		// ����һ����׼�������ֱ��Ӧ�����ϣ��ң��·��ƶ�
		int[][] vector = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		char target = word.charAt(k);
		//��ǰ�ڵ��ַ���ͬ���ұ��ڵ�������ַ���һ��Ԫ�أ������ɹ�
		if (target == board[i][j]) {
			if (k == word.length() - 1) {
				this.flag = true;
				return;
			}
			//������4�������ϼ�������
			for (int d = 0; d < 4; d++) {
				//������������ˣ��Ͳ����������������
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
