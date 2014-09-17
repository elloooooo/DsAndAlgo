package dsTest;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if(num.length == 0){
			return null;
		}

		TreeNode root = buildBST(num,0,num.length-1);
		return root;
	}

	private TreeNode buildBST(int[] num, int begin, int end) {
		if(begin==end){
			return new TreeNode(num[begin]);
		}
		if(begin+1==end){
			TreeNode root = new TreeNode(num[begin]);
			root.right = new TreeNode(num[end]);
			return root;
		}
		int mid = (begin+end)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = buildBST(num,begin,mid-1);
		root.right = buildBST(num,mid+1,end);
		return root;
	}

	public static void main(String[] args) {
		int[] num = {1,2,3,4};
		ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
		TreeNode t = c.sortedArrayToBST(num);
	}

}
