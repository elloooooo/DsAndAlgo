package dsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOutput {
	public String matrixOutPut(int rows, int col) {
		int tmp = 0;
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				tmp = i + j;
				sbf.append(tmp);
				sbf.append(" ");
			}
		}

		sbf.deleteCharAt(sbf.length() - 1);
		return sbf.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));

		while (true) {
			System.out.println("请输入行数：");
			String str = bfr.readLine();
			int rows = Integer.parseInt(str);
			System.out.println("请输入列数：");
			str = bfr.readLine();
			int col = Integer.parseInt(str);
			
			
			MatrixOutput m = new MatrixOutput();
			String res = m.matrixOutPut(rows, col);
			System.out.println(res);
		}
	}

}
