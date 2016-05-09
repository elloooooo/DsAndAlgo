package dsTest;


/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1
 * 
 * / \
 * 
 * 2 3
 * 
 * The root-to-leaf path 1->2 represents the number 12.
 * 
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 */
/**
 * @author Administrator
 * 二叉树的深度优先遍历
 */
public class SumRootToLeafNumbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int result;
	public int sumNumbers(TreeNode root) {
		if(root ==null){
			return 0;
		}
        dfs(root,0);
        return result;
	}
	
	private void dfs(TreeNode root, int tmpSum){
		if(root == null){
			return;
		}
		tmpSum = tmpSum*10+root.val;
		
		if(root.left==null&&root.right ==null){
			this.result += tmpSum;
		}
		if(root.left!=null){
			dfs(root.left, tmpSum);
		}
		if(root.right != null){
			dfs(root.right, tmpSum);
		}
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(8);
		TreeNode lchild = new TreeNode(3);
		TreeNode lrchild = new TreeNode(9);
		lrchild.left = new TreeNode(9);
		lrchild.right = new TreeNode(5);
		lchild.right = lrchild;
		t.left = lchild;
		t.right = new TreeNode(5);
		
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		int sum = s.sumNumbers(t);
		System.out.println(sum);

	}

}
