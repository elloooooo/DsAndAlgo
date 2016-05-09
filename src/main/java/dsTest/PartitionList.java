package dsTest;

import dataStructure.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		//����xֵ��ķ���һ���б�
		ListNode largeListEx = new ListNode(0);
		ListNode largeCur = largeListEx;
		//С�ķ���һ���б�
		ListNode smallListEx = new ListNode(0);
		ListNode smallCur = smallListEx;

		ListNode cur = head;

		while (cur != null) {
			if (cur.val >= x) {
				largeCur.next = cur;
				largeCur = largeCur.next;
			} else {
				smallCur.next = cur;
				smallCur = smallCur.next;
			}
			cur = cur.next;
		}
		//�ϲ�
		largeCur.next = null;
		smallCur.next = largeListEx.next;

		return smallListEx.next;
	}
}
