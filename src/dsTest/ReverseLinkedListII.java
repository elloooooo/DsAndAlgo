package dsTest;

public class ReverseLinkedListII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null||m==n) {
			return head;
		}
		ListNode pre = null;
		ListNode post = null;
		ListNode cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			if (i == m - 1) {
				pre = cur;
			}
			if (i == n) {
				post = cur.next;
			}
			cur = cur.next;
		}

		ListNode reversePart = reverse(head, pre, post);
		if (pre == null) {
			head.next = post;
			head = reversePart;
		} else {
			pre.next.next = post;
			pre.next = reversePart;
		}

		return head;
	}

	private ListNode reverse(ListNode head, ListNode pre, ListNode post) {
		ListNode cur = null;
		ListNode tmp = null;
		ListNode tmp2 = null;
		if (pre == null) {
			cur = head;
		} else {
			cur = pre.next;
		}
		
		if (cur.next != null) {
			tmp = cur.next.next;
			cur.next.next = cur;
			cur = cur.next;
		}
		
		while (tmp!=null&&!tmp.equals(post)) {
			tmp2 = tmp.next;
			tmp.next = cur;
			cur = tmp;
			tmp = tmp2;
		}

		return cur;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		ReverseLinkedListII r = new ReverseLinkedListII();
		ListNode res = r.reverseBetween(head, 1, 2);
		
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}
