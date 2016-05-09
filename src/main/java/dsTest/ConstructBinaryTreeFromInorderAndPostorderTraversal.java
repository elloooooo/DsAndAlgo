package dsTest;


/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postorder.length - 1]);

		int rootIndex = getIndex(inorder, root.val);

		int[] lInorder = new int[rootIndex];
		for (int i = 0; i < rootIndex; i++) {
			lInorder[i] = inorder[i];
		}

		int[] lPostorder = new int[lInorder.length];

		for (int i = 0; i < lInorder.length; i++) {
			lPostorder[i] = postorder[i];
		}

		root.left = buildTree(lInorder, lPostorder);

		int[] rInorder = new int[inorder.length - rootIndex - 1];

		for (int i = 0; i < inorder.length - rootIndex - 1; i++) {
			rInorder[i] = inorder[rootIndex + 1 + i];
		}

		int[] rPostorder = new int[postorder.length - lPostorder.length - 1];

		for (int i = 0; i < postorder.length - lPostorder.length - 1; i++) {
			rPostorder[i] = postorder[lPostorder.length  + i];
		}
		root.right = buildTree(rInorder,rPostorder);

		return root;
	}

	private int getIndex(int[] inorder, int val) {
		int i = 0;
		while (i < inorder.length) {
			if(inorder[i]==val){
				break;
			}
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		int[] inorder = { 2,1 };
		int[] postorder = { 2,1 };
		ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		TreeNode tree = c.buildTree(inorder, postorder);

	}

}
