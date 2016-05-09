package dsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * 
 * A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		//排序
		Arrays.sort(num);
		//深度优先搜索
		dfs(0,num,target,res,tmp);
		
		return res;
	}

	private void dfs(int index, int[] num, int target, List<List<Integer>> res,
			List<Integer> tmp) {
		if(target<0){
			return;
		}
		if(target==0){
			res.add(new ArrayList<Integer>(tmp));
		}
		for(int i=index;i<num.length;i++){
			tmp.add(num[i]);
			dfs(i+1,num,target-num[i],res,tmp);
			tmp.remove(tmp.size()-1);
			//去除重复
			while(i<num.length-1&&num[i]==num[i+1]){
				i++;
			}
		}
		
	}

	public static void main(String[] args) {
		int[] data = {1,1};
		CombinationSumII c = new CombinationSumII();
		List<List<Integer>> res = c.combinationSum2(data, 2);
	}

}
