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
 * ����ÿһ������Һ��Ӷ��Ǹõ������������һ���㣬���Գ����������һ���������
 * 
 * ����Ҫ����һ��curָ�룬������һ���ڵ㣬�����ſ����ڵݹ��н���ǰ������Ľڵ���Ϊcurָ��ڵ���Һ���
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
			//ÿ�ν���ǰ�ڵ���Ϊ��һ���ڵ���Һ��ӣ��ÿ���һ���ڵ�����ӣ���󽫵�ǰ�ڵ㱣�浽curָ����
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
