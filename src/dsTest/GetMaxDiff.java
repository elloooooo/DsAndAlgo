package dsTest;

/**
 * 阿里笔试题
 * 获得二叉树中两界点的最大差值
 */
public class GetMaxDiff {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	private int max;
	private int min;
	public int getMaxDiff(TreeNode root){
		if(root == null){
			return 0;
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		inorderTraversal(root);
		return Math.abs(max-min);
	}
	
	private void inorderTraversal(TreeNode root){
		if (root == null)
			return;
		if(root.val>max){
			max = root.val;
		}
		if(root.val<min){
			min = root.val;
		}
		if (root.left != null) {
			inorderTraversal(root.left);
		}
		if (root.right != null) {
			inorderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		GetMaxDiff b = new GetMaxDiff();
		int res = b.getMaxDiff(root);
		System.out.println(res);
	}
}
