package dsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü
 * ¡­ ¡Ü ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 */
public class CombinationSum {
	private List<List<Integer>> res;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		dfs(0,candidates,target,tmp);
			
		return res;
	}

	private void dfs(int index, int[] candidates, int target, List<Integer> tmp) {
		if(target<0){
			return;
		}
		if(target==0){
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=index;i<candidates.length;i++){
			tmp.add(candidates[i]);
			dfs(i,candidates,target-candidates[i],tmp);
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] data = {2,3,6,7};
		CombinationSum c = new CombinationSum();
		List<List<Integer>> res = c.combinationSum(data, 7);

	}

}
