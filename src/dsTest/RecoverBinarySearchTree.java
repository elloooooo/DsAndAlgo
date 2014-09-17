package dsTest;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 */
public class RecoverBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode mistake1;
	private TreeNode mistake2;
	private TreeNode pre;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		findTwoNode(root);
		// ����������Ľڵ㣬ֵ����һ��
		if (mistake1 != null && mistake2 != null) {
			int tmp = mistake1.val;
			mistake1.val = mistake2.val;
			mistake2.val = tmp;
		}

	}

	/**
	 * �����������ÿһ��Ԫ��Ӧ�ñ���ǰ���һ��Ԫ�ش�Ŷԣ����Լ���һ��preָ�룬ָ��ǰ����Ԫ�ص�ǰһ��ָ�룬
	 * �����һ�η���pre.val>root.val,���¼pre���ڶ��η��ּ�¼root
	 */
	private void findTwoNode(TreeNode root) {
		if (root == null) {
			return;
		}

		findTwoNode(root.left);

		if (pre != null && root.val < pre.val) {

			if (mistake1 == null) {
				mistake1 = pre;
			}
			mistake2 = root;
		}

		pre = root;

		findTwoNode(root.right);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(2);

		RecoverBinarySearchTree r = new RecoverBinarySearchTree();
		r.recoverTree(root);
	}

}
