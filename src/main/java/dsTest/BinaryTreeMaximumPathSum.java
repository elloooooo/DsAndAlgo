package dsTest;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 * 1
 * 
 * / \
 * 
 * 2 3
 * 
 * Return 6.
 */
public class BinaryTreeMaximumPathSum {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		// ���·����������
		int lMax = maxPathSum(root.left);
		// ���·����������
		int rMax = maxPathSum(root.right);
		// ���·�������ڵ�
		int rootMax = root.val;
		int tmp = maxPathSumFromRoot(root.right);
		rootMax += tmp > 0 ? tmp : 0;
		tmp = maxPathSumFromRoot(root.left);
		rootMax += tmp > 0 ? tmp : 0;

		return max(lMax, rMax, rootMax);
	}

	private int maxPathSumFromRoot(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfs(root, 0,Integer.MIN_VALUE);
	}

	/**
	 * @param root
	 * @param sum ֮ǰ���ʹ��Ľڵ���ۼӺ�
	 * @param maxSum ���͵�ˮλ���
	 * @return
	 * 
	 * �������������
	 */
	private int dfs(TreeNode root, int sum,int maxSum) {
		if (root == null) {
			return maxSum;
		}
		sum += root.val;
		maxSum = sum>maxSum? sum:maxSum;
		if (root.left == null && root.right == null) {
			return maxSum;
		}
		maxSum = dfs(root.left, sum,maxSum);
		return dfs(root.right, sum,maxSum);
	}

	private int max(int a, int b, int c) {
		int max = Integer.MIN_VALUE;
		if (a > max) {
			max = a;
		}
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-1);
		/*
		 * root.left.left = new TreeNode(3); root.left.left.left = new
		 * TreeNode(4); root.left.left.left.left = new TreeNode(5);
		 */
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		int res = b.maxPathSum(root);
		System.out.println(res);

	}

}
