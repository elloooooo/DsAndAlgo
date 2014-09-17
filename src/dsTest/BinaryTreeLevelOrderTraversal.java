package dsTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 3
 * 
 * / \
 * 
 * 9 20
 * 
 * / \
 * 
 * 15 7
 * 
 * return its level order traversal as: [ [3], [9,20], [15,7] ]
 */
public class BinaryTreeLevelOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	//增加了辅助数据结构，里面保存了节点的高度
	private static class Node{
		TreeNode node;
		int level;
		Node(TreeNode treenode,int x){
			node = treenode;
			level = x;
		}
	}
	//利用广度优先遍历，为所有的节点构造含有节点高度的数据结构
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null){
			return res;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(root,0));
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		
		while(!queue.isEmpty()){
			Node node = queue.poll();
			
			if(!map.containsKey(node.level)){
				List<Integer> _list = new ArrayList<Integer>();
				_list.add(node.node.val);
				map.put(node.level, _list);
			}else{
				map.get(node.level).add(node.node.val);
			}
			
			if(node.node.left!=null){
				queue.add(new Node(node.node.left,node.level+1));
			}
			
			if(node.node.right!= null){
				queue.add(new Node(node.node.right,node.level+1));
			}
			
		}
		
		//从第0级一直到最后一级,都加到res这个list中
		int key = 0;
		while(map.containsKey(key)){
			res.add(map.get(key));
			key++;
		}
		
		return res;
	}

	//返回的list中的元素先是最底层元素集合，然后依次是上层元素集合
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null){
			return res;
		}
		
		List<Integer> tmpRes = new ArrayList<Integer>();
		int curlevel = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(root,0));
		
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		
		while(!queue.isEmpty()){
			Node node = queue.poll();
			if(node.node.left!=null){
				queue.add(new Node(node.node.left,node.level+1));
			}
			if(node.node.right!=null){
				queue.add(new Node(node.node.right,node.level+1));
			}
			
			if(node.level!=curlevel){
				stack.push(tmpRes);
				tmpRes = new ArrayList<Integer>();
				curlevel = node.level;
			}
			tmpRes.add(node.node.val);
		}
		stack.push(tmpRes);
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> res = b.levelOrderBottom(root);
	}

}
