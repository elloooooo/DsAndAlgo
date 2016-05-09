package dsTest;


public class ValidateBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode pre;
	/**
	 * 中序遍历树，每一个元素应该比它前面的一个元素大才对，所以加入一个pre指针，指向当前处理元素的前一个指针，
	 * 如果第一次发现pre.val>=root.val,则返回false
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (isValidBST(root.left)) {//如果左子树正常，看下当前节点
			if (pre != null && pre.val >= root.val) {
				return false;
			}
		} else {//左子树不正常
			return false;
		}

		pre = root;
		//左子树正常且当前节点正常，结果取决于右子树
		return isValidBST(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(2);

		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		System.out.println(v.isValidBST(root));

	}

}
