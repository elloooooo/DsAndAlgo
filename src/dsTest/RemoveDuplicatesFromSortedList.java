package dsTest;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2.
 * 
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;

		while (cur != null) {
			if (cur.next != null && cur.val == cur.next.val) {
				cur.next = cur.next.next;
				continue;
			}
			cur = cur.next;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);

		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		r.deleteDuplicates(head);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
