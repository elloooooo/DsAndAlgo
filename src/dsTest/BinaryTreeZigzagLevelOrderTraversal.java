package dsTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private class Node {
		TreeNode node;
		int level;

		Node(TreeNode treeNode, int x) {
			node = treeNode;
			level = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(root, 0));

		boolean curDirect = true;// true左向右；false右向左
		int curLevel = 0;

		List<Integer> tmp = new ArrayList<Integer>();

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (curLevel != node.level) {
				List<Integer> rows = new ArrayList<Integer>(tmp);
				//将结果加入res时，判断一下要不要reverse
				if(curDirect){
					res.add(reverse(rows));
				}else{
					res.add(rows);
				}
				
				tmp.clear();
				curDirect = !curDirect;
				curLevel = node.level;
			}
			if (node.node.right != null) {
				queue.add(new Node(node.node.right, node.level + 1));
			}
			if (node.node.left != null) {
				queue.add(new Node(node.node.left, node.level + 1));
			}
			tmp.add(node.node.val);
		}
		//最后一个结果也要哦，将结果加入res时，判断一下要不要reverse
		List<Integer> rows = new ArrayList<Integer>(tmp);
		if(curDirect){
			res.add(reverse(rows));
		}else{
			res.add(rows);
		}
		return res;
	}

	private List<Integer> reverse(List<Integer> rows) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i=rows.size()-1;i>=0;i--){
			res.add(rows.get(i));
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> res = s.zigzagLevelOrder(root);

	}

}
