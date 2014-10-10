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
		//Ϊ�˲������㣬��head�ڵ�ǰ����һ���ٽڵ�
		fakeHead.next = head;
		//��ǰ�������Ľڵ�
		ListNode cur = fakeHead;
		//Ҫɾ���Ľڵ�ǰ��Ľڵ�
		ListNode pre = fakeHead;
		
		//curָ�����ƶ�n
		while(n>0){
			cur = cur.next;
			n--;
		}
		//Ȼ��pre��ʼ��curһ���ƶ���pre��cur����n�ľ���
		while(cur.next!=null){
			pre = pre.next; 
			cur = cur.next;
		}
		//ȥ��pre����Ľڵ�
		if(pre.next.next!=null){
			pre.next = pre.next.next;
		}else{
			pre.next = null;
		}
		//���preΪfakeHead˵��Ҫȥ���Ľڵ�ʱhead�ڵ㣬����ֱ�ӷ���pre.next
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
