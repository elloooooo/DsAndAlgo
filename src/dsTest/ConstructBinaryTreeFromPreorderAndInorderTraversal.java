package dsTest;

/**
 * @author Administrator Given preorder and inorder traversal of a tree,
 *         construct the binary tree. Note: You may assume that duplicates do
 *         not exist in the tree.
 * 
 *         Answer: ��������еĵ�һ���ڵ���Ǹ��ڵ㣬����ڵ�����������н����л��֣����Ϊ������������������ұ�Ϊ���������������
 *         ������������������г���Ϊl�������������һ���ڵ����l��Ԫ�أ�Ϊ��������������������
 *         ������������������г���Ϊr����������������ٺ����r��Ԫ�أ�Ϊ����������������
 * 
 *         ����������ƹ�ϵ���Ϳɵ���
 * 
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// �����븴�����飬����ͨ�������±������������п��ƣ����Ƿ����±�ļ��������Ƿ������޷�������ȷ
//	public TreeNode buildTree1(int[] preorder, int[] inorder) {
//		if (preorder.length == 0 || inorder.length == 0)
//			return null;
//		return buildTree(preorder, inorder, 0, preorder.length - 1, 0,
//				inorder.length - 1);
//	}
//
//	private TreeNode buildTree(int[] preorder, int[] inorder, int pstart,
//			int pend, int istart, int iend) {
//		TreeNode root = new TreeNode(preorder[pstart]);
//		int rootIndex = istart;
//
//		while (rootIndex < iend) {
//			if (inorder[rootIndex] == root.val) {
//				break;
//			}
//			rootIndex++;
//		}
//		int leftLength = rootIndex - istart;
//		int rightLength = iend - rootIndex;
//
//		root.left = buildTree(preorder, inorder, pstart + 1, pstart
//				+ leftLength, istart, istart + leftLength - 1);
//
//		root.right = buildTree(preorder, inorder, pend - rightLength, pend,
//				rootIndex + 1, rootIndex + rightLength - 1);
//
//		return root;
//	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		if (preorder.length != 1) {
			int index = findRootIndexInInorder(preorder[0], inorder);
			// ��������������������
			int[] lInorder = new int[index];
			for (int i = 0; i < index; i++) {
				lInorder[i] = inorder[i];
			}
			// ��������������������
			int[] lPreorder = new int[index];
			for (int i = 0; i < index; i++) {
				lPreorder[i] = preorder[i + 1];
			}
			root.left = buildTree(lPreorder, lInorder);

			// ��������������������
			int[] rInorder = new int[inorder.length - index - 1];
			for (int i = 0; i < inorder.length - index - 1; i++) {
				rInorder[i] = inorder[index + 1 + i];
			}
			// �������������������
			int[] rPreorder = new int[inorder.length - index - 1];
			for (int i = 0; i < inorder.length - index - 1; i++) {
				rPreorder[i] = preorder[index + i + 1];
			}
			root.right = buildTree(rPreorder, rInorder);
		}
		return root;
	}

	/**
	 * ��ѯ��������ĵ�һ���ڵ㣬�������������е��±�
	 * 
	 * @param val
	 * @param inorder
	 * @return
	 */
	private int findRootIndexInInorder(int val, int[] inorder) {
		int index = 0;
		while (index < inorder.length) {
			if (inorder[index] == val) {
				break;
			}
			index++;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] preorder = { 4, 2, 1, 3, 5, 6 };
		int[] inorder = { 1, 2, 3, 4, 5, 6 };
		ConstructBinaryTreeFromPreorderAndInorderTraversal b = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		TreeNode root = b.buildTree(preorder, inorder);
	}

}
