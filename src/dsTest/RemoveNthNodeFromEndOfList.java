package dsTest;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 */

public class RemoveNthNodeFromEndOfList {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null){
			return null;
		}
		
		ListNode fakeHead = new ListNode(0);
		//为了操作方便，在head节点前增加一个假节点
		fakeHead.next = head;
		//当前遍历到的节点
		ListNode cur = fakeHead;
		//要删除的节点前面的节点
		ListNode pre = fakeHead;
		
		//cur指针先移动n
		while(n>0){
			cur = cur.next;
			n--;
		}
		//然后pre开始与cur一起移动，pre与cur保持n的距离
		while(cur.next!=null){
			pre = pre.next; 
			cur = cur.next;
		}
		//去除pre后面的节点
		if(pre.next.next!=null){
			pre.next = pre.next.next;
		}else{
			pre.next = null;
		}
		//如果pre为fakeHead说明要去除的节点时head节点，所以直接返回pre.next
		return pre.equals(fakeHead)?pre.next:head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
		/*head.next.next = new ListNode(3);*/
		ListNode res = RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 1);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}
