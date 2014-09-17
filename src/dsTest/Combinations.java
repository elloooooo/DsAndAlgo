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
		//如果dps到指定的深度，就将路径结果加入res
		if(--k==0){
			res.add(new ArrayList<Integer>(tmp));
			//注意加入res后需要回溯
			tmp.remove(tmp.size()-1);
			return;
		}
		//否则就要继续dps
		for(int j=i;j<this.n;j++){
			dps(++i, k, res, tmp);
		}
		//搜索完一个节点之后的所有节点后，需要回溯
		tmp.remove(tmp.size()-1);
	}

	public static void main(String[] args) {
		Combinations c = new Combinations();
		c.combine(4, 3);
	}

}
