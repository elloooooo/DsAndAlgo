package dsTest;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	private int maxDepth;
	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		maxDepth = Integer.MIN_VALUE;
		dfs(root,0);
		return maxDepth;
	}

	private void dfs(TreeNode root, int sum) {
		if(root==null){
			return;
		}
		sum++;
		if(root.left==null&&root.right==null){
			if(sum>maxDepth){
				maxDepth = sum;
			}
		}
		dfs(root.left,sum);
		dfs(root.right,sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
