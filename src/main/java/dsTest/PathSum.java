package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */


public class PathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	/**
	 * dfs���ۼӺͣ���Ҷ�ӽڵ�ʱ�ж��ۼӽ���ǲ�������ֵ
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return dfs(root, 0, sum);
	}

	private boolean dfs(TreeNode root, int tmp, int sum) {
		if (root == null) {
			return false;
		}
		tmp += root.val;

		if (root.left == null && root.right == null) {
			if (tmp == sum) {
				return true;
			} else {
				return false;
			}
		}

		return dfs(root.left, tmp, sum) || dfs(root.right, tmp, sum);
	}

	
	//dfs,ͬʱ����·��
	private List<List<Integer>> paths;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		paths = new ArrayList<List<Integer>>();
		if (root == null) {
			return paths;
		}
		List<Integer> tmpPath = new ArrayList<Integer>();
		
		dfs(root,0,sum,tmpPath);
		return paths;
	}

	private void dfs(TreeNode root, int tmp, int sum, List<Integer> tmpPath) {
		tmp += root.val;
		tmpPath.add(root.val);
		if(root.left==null&&root.right==null){
			if(tmp==sum){
				//�൱��Ϊ����������·����һ��copy������paths�У�
				ArrayList<Integer> _tmp = new ArrayList<Integer>(tmpPath);
				paths.add(_tmp);
				//�����������paths�еĶ��������ʼ�����ŵݹ�����ڸı䣬����ֻ�ܵõ�[[1],[1]]
//				paths.add(tmpPath);
			}
		}
		
		if(root.left!=null){
			dfs(root.left,tmp,sum,tmpPath);
			//ע��ÿ�εݹ鷵�غ���ʵ��������εݹ�Ľڵ㵽·���У�Ҫȥ�����������γ��µ�·��
			tmpPath.remove(tmpPath.size()-1);
		}
		if(root.right!=null){
			dfs(root.right,tmp,sum,tmpPath);
			//ע��ÿ�εݹ鷵�غ���ʵ��������εݹ�Ľڵ㵽·���У�Ҫȥ�����������γ��µ�·��
			tmpPath.remove(tmpPath.size()-1);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		PathSum p = new PathSum();
		List<List<Integer>> res = p.pathSum(root,8);
	}

}
