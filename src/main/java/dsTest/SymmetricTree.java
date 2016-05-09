package dsTest;


/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		return check(root.left,root.right);
	}
	
	
	private boolean check(TreeNode left, TreeNode right) {
		if(left==null&&right==null){
			return true;
		}
		if(left==null||right==null){
			return false;
		}
		return left.val == right.val&&check(left.left,right.right)&&check(left.right,right.left);
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		SymmetricTree s = new SymmetricTree();
		s.isSymmetric(root);
		
	}

}
