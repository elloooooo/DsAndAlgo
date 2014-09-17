package dsTest;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */
/**
 * @author Administrator
 * ������ȱ�����Ȼ���¼��С��·���ۼ�ֵ
 */
public class MinimumDepthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int minPath;
	
	public int minDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		int sum = 0;
		minPath = Integer.MAX_VALUE;
		dfs(root,sum);

		return minPath;
	}

	private void dfs(TreeNode root, int sum) {
		if(root==null){
			return;
		}
		sum ++;
		if(root.left==null&&root.right==null){
			if(sum<minPath){
				minPath = sum;
			}
		}
		dfs(root.left,sum);
		dfs(root.right,sum);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		MinimumDepthOfBinaryTree m = new MinimumDepthOfBinaryTree();
		int res = m.minDepth(root);
		System.out.println(res);
	}

}
