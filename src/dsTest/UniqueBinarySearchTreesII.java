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
	 * ����һ��list��list�а���start-end��Щ������ɵ����ж�����
	 */
	public ArrayList<TreeNode> generateTree(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		ArrayList<TreeNode> leftTree = new ArrayList<TreeNode>();
		ArrayList<TreeNode> rightTree = new ArrayList<TreeNode>();
		//ѡ��һ��start-end������һ��������Ϊ���ڵ㣬��������Ϊ������������ԭ�ϣ��Ҳ�����Ĺ�����������ԭ��
		for (int i = start; i <= end; i++) {
			leftTree = generateTree(start, i - 1);
			rightTree = generateTree(i + 1, end);
			//�������������е������������������е���������������������п��ܵ����
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
