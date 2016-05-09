package dsTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import dsTest.BinaryTreePostorderTraversal.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,2,3].
 */
public class BinaryTreePreorderTraversal {
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) {
	    	val = x; 
	    }
	}
	/**
	 * µ›πÈÀ„∑®
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root==null){
			return res;
		}
		res.add(root.val);
		res.addAll(preorderTraversal(root.left));
		res.addAll(preorderTraversal(root.right));
        return res;
    }
	
	
	/**
	 * ∑«µ›πÈÀ„∑®
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root==null){
			return res;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		res.add(root.val);
		TreeNode top = root;
		
		while(!stack.isEmpty()){
			top = stack.peek();
			if(top.left==null&&top.right==null){
				stack.pop();
			}
			if(top.left!=null){
				res.add(top.left.val);
				stack.push(top.left);
				top.left = null;
				continue;
			}
			if(top.right!=null){
				res.add(top.right.val);
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
		
		BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();
//		List<Integer> answer = b.postorderTraversal(root);
		List<Integer> answer = b.preorderTraversal2(root);
		
		for(Integer i:answer){
			System.out.println(i);
		}

	}

}
