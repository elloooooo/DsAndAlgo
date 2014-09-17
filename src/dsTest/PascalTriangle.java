package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */
public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return res;
		}
		List<Integer> _row = new ArrayList<Integer>();
		_row.add(1);
		res.add(_row);

		for (int i = 1; i < numRows; i++) {
			_row = new ArrayList<Integer>();
			_row.add(1);
			for (int j = 1; j < i; j++) {
				_row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
			}
			_row.add(1);
			res.add(_row);
		}
		return res;
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		if (rowIndex == 0) {
			res.add(1);
			return res;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 1; i <= rowIndex; i++) {
			res = new ArrayList<Integer>();
			if (tmp.size() == 0) {
				tmp.add(1);
			}
			res.add(1);
			for (int j = 1; j < i; j++) {
				res.add(tmp.get(j - 1) + tmp.get(j));
			}
			res.add(1);
			tmp = res;
		}
		return res;
	}

	public static void main(String[] args) {
		PascalTriangle p = new PascalTriangle();
		// List<List<Integer>> res = p.generate(5);
		List<Integer> rows = p.getRow(3);

	}

}
