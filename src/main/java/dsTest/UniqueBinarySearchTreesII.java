package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		return generateTree(0, n - 1);
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 * 返回一个list，list中包含start-end这些数字组成的所有二叉树
	 */
	public ArrayList<TreeNode> generateTree(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		ArrayList<TreeNode> leftTree = new ArrayList<TreeNode>();
		ArrayList<TreeNode> rightTree = new ArrayList<TreeNode>();
		//选择一个start-end中任意一个数字作为根节点，其左侧的作为构建左子树的原料，右侧的做的构建右子树的原料
		for (int i = start; i <= end; i++) {
			leftTree = generateTree(start, i - 1);
			rightTree = generateTree(i + 1, end);
			//将左子树集合中的子树与右子树集合中的子树搭配起来，组成所有可能的情况
			for (int j = 0; j < leftTree.size(); j++) {
				for (int k = 0; k < rightTree.size(); k++) {
					TreeNode n = new TreeNode(i + 1);
					n.left = leftTree.get(j);
					n.right = rightTree.get(k);
					result.add(n);
				}
			}
		}
		return result;
	}

}
