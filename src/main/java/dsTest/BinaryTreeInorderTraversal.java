package dsTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * @param root
	 * @return
	 * 递归解法
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		if (root.left != null) {
			List<Integer> ltree = inorderTraversal(root.left);
			res.addAll(ltree);
		}
		res.add(root.val);
		if (root.right != null) {
			List<Integer> rtree = inorderTraversal(root.right);
			res.addAll(rtree);
		}
		return res;
	}

	/**
	 * @param root
	 * @return
	 * 循环解法
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (top.left != null) {
				stack.push(top.left);
				top.left = null;
				continue;
			}
			
			res.add(top.val);
			stack.pop();

			if (top.right != null) {
				stack.push(top.right);
				top.right = null;
				continue;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
