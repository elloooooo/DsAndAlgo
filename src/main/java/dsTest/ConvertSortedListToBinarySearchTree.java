package dsTest;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */


public class ConvertSortedListToBinarySearchTree {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head==null){
			return null;
		}
		//如果链表只有一个节点
		if(head.next==null){
			return new TreeNode(head.val);
		}
		//如果链表有两个节点
		if(head.next.next == null){
			TreeNode root = new TreeNode(head.val);
			root.right = new TreeNode(head.next.val);
			return root;
		}
		
		//两个节点以上的，则查找链表的中点
		ListNode midNode = findMidNode(head);
		ListNode newbegin = midNode.next;
		
		ListNode cur = head;
		while(cur.next!=null&&!cur.next.equals(midNode)){
			cur = cur.next;
		}
		cur.next = null;
		
		TreeNode root = new TreeNode(midNode.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(newbegin);
		return root;
	}

	
	private ListNode findMidNode(ListNode head) {
		if(head ==null){
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ConvertSortedListToBinarySearchTree c = new ConvertSortedListToBinarySearchTree();
		TreeNode t = c.sortedListToBST(head);
	}

}
