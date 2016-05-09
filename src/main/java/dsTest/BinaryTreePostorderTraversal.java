package dsTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [3,2,1].

	Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class BinaryTreePostorderTraversal {
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) {
	    	val = x; 
	    }
	}
	
	/**
	 * 递归算法
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root==null){
			return res;
		}
		res.addAll(postorderTraversal(root.left));
		res.addAll(postorderTraversal(root.right));
		
		res.add(root.val);
        return res;
    }
	
	
	/**
	 * 循环方法
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal2(TreeNode root){
		List<Integer> res = new LinkedList<Integer>();
		if(root==null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode top = stack.peek();
			
			if(top.left==null&&top.right==null){
				res.add(top.val);
				stack.pop();
			}
			if(top.left!=null){
				stack.push(top.left);
				top.left = null;
				continue;
			}
			if(top.right!=null){
				stack.push(top.right);
				top.right = null;
				continue;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		BinaryTreePostorderTraversal b = new BinaryTreePostorderTraversal();
//		List<Integer> answer = b.postorderTraversal(root);
		List<Integer> answer = b.postorderTraversal2(root);
		
		for(Integer i:answer){
			System.out.println(i);
		}

	}

}
