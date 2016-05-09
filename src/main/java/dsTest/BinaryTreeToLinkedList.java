package dsTest;

/**
 * @author Administrator
 * 将二叉搜索树转化为双链表
 * 
 * 对二叉树进行中序遍历，每一个节点的左孩子指向前一个节点，右指针指向后一个节点
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
	//记录头节点
	private TreeNode head;
	//记录上一个节点
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
