package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
/**
 * @author Administrator
 * 获得一个数组的所有子集
 */
public class Subsets {

	private List<List<Integer>> res;

	public List<List<Integer>> subsets(int[] S) {
		res = new ArrayList<List<Integer>>();
		//对数组的每一个元素进行深度优先搜索
		for (int i = 0; i < S.length; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			dfs(S, i, tmp);
		}
		//最后加一个空集，空集是所有集合的子集
		res.add(new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] s, int index, List<Integer> tmp) {
		tmp.add(s[index]);
		//比s[index]大的节点都可以作为s[index]的下一个节点，对所有这些节点进行dfs
		for (int i = 0; i < s.length; i++) {
			if (s[i] > s[index] && i != index) {
				dfs(s, i, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
		res.add(new ArrayList<Integer>(tmp));
	}
	
	
	
	
	/**
	 * @param S
	 * @return
	 * 
	 * 有重复的输入时，求所有子集，不能有重复子集
	 */
	public List<List<Integer>> subsetsWithDup(int[] S) {
		res = new ArrayList<List<Integer>>();
		//先排序
		sort(S);
		//对数组的每一个元素进行深度优先搜索
		for (int i = 0; i < S.length; i++) {
			//同一个数字，只进行一次dfs
			if(i==0||(i>0&&S[i]!=S[i-1])){
				List<Integer> tmp = new ArrayList<Integer>();
				dfsWithDup(S, i, tmp);
			}
		}
		//最后加一个空集，空集是所有集合的子集
		res.add(new ArrayList<Integer>());
		return res;
	}
	
	private void dfsWithDup(int[] s, int index, List<Integer> tmp) {
		tmp.add(s[index]);
		//保存上一次循环的值
		Integer lastVal = null;
		//比s[index]大的节点都可以作为s[index]的下一个节点，对所有这些节点进行dfs
		for (int i = index+1; i < s.length; i++) {
			//从index+1开始检测，只有值大于当前节点值且值不和上次循环相同的节点，才是当前节点的下一节点
			if (s[i] >= s[index]&&(lastVal==null||lastVal!=s[i])) {
				lastVal = s[i];
				dfsWithDup(s, i, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
		res.add(new ArrayList<Integer>(tmp));
	}
	
	private void sort(int[] s){
		for(int i=0;i<s.length;i++){
			int tmp = s[i];
			int minIndex = minIndex(s,i);
			s[i] = s[minIndex];
			s[minIndex] = tmp;
		}
	}

	private int minIndex(int[] s, int i) {
		int minIndex = i;
		for(int j=i+1;j<s.length;j++){
			if(s[j]<s[minIndex]){
				minIndex = j;
			}
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		int[] s = {1,2,2};
		Subsets sub= new Subsets();
		sub.subsetsWithDup(s);
	}
}
