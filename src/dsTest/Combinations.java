package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations {
	private int n;

	public List<List<Integer>> combine(int n, int k) {
		this.n = n;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n == 0 || k == 0) {
			return res;
		}
		for (int i = 1; i <= n; i++) {
			dps(i, k, res, new ArrayList<Integer>());
		}
		return res;
	}

	private void dps(int i, int k, List<List<Integer>> res, ArrayList<Integer> tmp) {
		tmp.add(Integer.valueOf(i));
		//���dps��ָ������ȣ��ͽ�·���������res
		if(--k==0){
			res.add(new ArrayList<Integer>(tmp));
			//ע�����res����Ҫ����
			tmp.remove(tmp.size()-1);
			return;
		}
		//�����Ҫ����dps
		for(int j=i;j<this.n;j++){
			dps(++i, k, res, tmp);
		}
		//������һ���ڵ�֮������нڵ����Ҫ����
		tmp.remove(tmp.size()-1);
	}

	public static void main(String[] args) {
		Combinations c = new Combinations();
		c.combine(4, 3);
	}

}
