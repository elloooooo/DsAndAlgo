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
	 * �����������ÿһ��Ԫ��Ӧ�ñ���ǰ���һ��Ԫ�ش�Ŷԣ����Լ���һ��preָ�룬ָ��ǰ����Ԫ�ص�ǰһ��ָ�룬
	 * �����һ�η���pre.val>=root.val,�򷵻�false
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (isValidBST(root.left)) {//������������������µ�ǰ�ڵ�
			if (pre != null && pre.val >= root.val) {
				return false;
			}
		} else {//������������
			return false;
		}

		pre = root;
		//�����������ҵ�ǰ�ڵ����������ȡ����������
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
