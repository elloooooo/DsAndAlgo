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
 * ���һ������������Ӽ�
 */
public class Subsets {

	private List<List<Integer>> res;

	public List<List<Integer>> subsets(int[] S) {
		res = new ArrayList<List<Integer>>();
		//�������ÿһ��Ԫ�ؽ��������������
		for (int i = 0; i < S.length; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			dfs(S, i, tmp);
		}
		//����һ���ռ����ռ������м��ϵ��Ӽ�
		res.add(new ArrayList<Integer>());
		return res;
	}

	private void dfs(int[] s, int index, List<Integer> tmp) {
		tmp.add(s[index]);
		//��s[index]��Ľڵ㶼������Ϊs[index]����һ���ڵ㣬��������Щ�ڵ����dfs
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
	 * ���ظ�������ʱ���������Ӽ����������ظ��Ӽ�
	 */
	public List<List<Integer>> subsetsWithDup(int[] S) {
		res = new ArrayList<List<Integer>>();
		//������
		sort(S);
		//�������ÿһ��Ԫ�ؽ��������������
		for (int i = 0; i < S.length; i++) {
			//ͬһ�����֣�ֻ����һ��dfs
			if(i==0||(i>0&&S[i]!=S[i-1])){
				List<Integer> tmp = new ArrayList<Integer>();
				dfsWithDup(S, i, tmp);
			}
		}
		//����һ���ռ����ռ������м��ϵ��Ӽ�
		res.add(new ArrayList<Integer>());
		return res;
	}
	
	private void dfsWithDup(int[] s, int index, List<Integer> tmp) {
		tmp.add(s[index]);
		//������һ��ѭ����ֵ
		Integer lastVal = null;
		//��s[index]��Ľڵ㶼������Ϊs[index]����һ���ڵ㣬��������Щ�ڵ����dfs
		for (int i = index+1; i < s.length; i++) {
			//��index+1��ʼ��⣬ֻ��ֵ���ڵ�ǰ�ڵ�ֵ��ֵ�����ϴ�ѭ����ͬ�Ľڵ㣬���ǵ�ǰ�ڵ����һ�ڵ�
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
