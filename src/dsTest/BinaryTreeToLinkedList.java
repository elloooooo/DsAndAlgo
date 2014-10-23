package dsTest;

/**
 * @author Administrator
 * ������������ת��Ϊ˫����
 * 
 * �Զ������������������ÿһ���ڵ������ָ��ǰһ���ڵ㣬��ָ��ָ���һ���ڵ�
 */
public class BinaryTreeToLinkedList {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	//��¼ͷ�ڵ�
	private TreeNode head;
	//��¼��һ���ڵ�
	private TreeNode prev;
	
	public void convertBinaryTreeToList(TreeNode root) {
		if (root == null) {
			return;
		}
		convertBinaryTreeToList(root.left);
		convert(root);
		convertBinaryTreeToList(root.right);
		
	}

	private void convert(TreeNode root) {
		root.left = prev;
		if(prev==null){
			head = root;
		}else{
			prev.right = root;
		}
		prev = root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		BinaryTreeToLinkedList b = new BinaryTreeToLinkedList();
		b.convertBinaryTreeToList(root);

		while(b.head!=null){
			System.out.println(b.head.val);
			b.head = b.head.right;
		}
	}

}
