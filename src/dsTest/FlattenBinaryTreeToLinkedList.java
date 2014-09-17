package dsTest;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 * 1 / \ 2 5 / \ \ 3 4 6
 * 
 * The flattened tree should look like: 1 \ 2 \ 3 \ 4 \ 5 \ 6
 * 
 * Hints: If you notice carefully in the flattened tree, each node's right child
 * points to the next node of a pre-order traversal.
 */
/**
 * @author Administrator
 * Answer:
 * 由于每一个点的右孩子都是该点先序遍历的下一个点，所以程序主题就是一个先序遍历
 * 
 * 但是要利用一个cur指针，保存上一个节点，这样才可以在递归中将当前正处理的节点设为cur指向节点的右孩子
 * 
 */
public class FlattenBinaryTreeToLinkedList {
	private TreeNode cur;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		cur = null;
		preTravel(root);

	}

	private void preTravel(TreeNode node) {
		if(node==null){
			return;
		}
		TreeNode left = node.left;
		TreeNode right = node.right;
		
		if(cur == null){
			cur = node;
		}else{
			//每次将当前节点设为上一个节点的右孩子，置空上一个节点的左孩子，最后将当前节点保存到cur指针中
			cur.left = null;
			cur.right = node;
			cur = node;
		}
		
		preTravel(left);
		preTravel(right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
		f.flatten(root);

	}

}
