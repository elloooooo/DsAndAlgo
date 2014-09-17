package dsTest;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 */
public class BalancedBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if(root==null){
			return true;
		}
		//һ������������ƽ��ģ�������Ҳ��ƽ��ģ����ж��������ǲ���һ��ƽ�����
		//�൱�ں�����������Ϊÿһ����������Һ��ӵ����ߣ�Ȼ��ȽϿ�����Ƿ�С��1��
		if(isBalanced(root.left)&&isBalanced(root.right)){
			int lheight = treeHeight(root.left);
			int rheight = treeHeight(root.right);
			if(Math.abs(lheight-rheight)>1){
				return false;
			}
			return true;
		}else{
			return false;
		}
	}

	private int treeHeight(TreeNode root) {
		if(root==null){
			return 0;
		}
		int lheight = treeHeight(root.left);
		int rheight = treeHeight(root.right);

		return lheight>rheight?lheight+1:rheight+1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		BalancedBinaryTree b = new BalancedBinaryTree();
		boolean res = b.isBalanced(root);
		System.out.println(res);
			
	}

}
