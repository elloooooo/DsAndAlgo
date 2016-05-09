package dsTest;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null)return l2;
		if(l2==null)return l1;
		ListNode mergeHead = null;
		
		if(l1.val<l2.val){
			mergeHead = l1;
			l1 = l1.next;
		}else{
			mergeHead = l2;
			l2 = l2.next;
		}
		mergeHead.next = mergeTwoLists(l1, l2);
		return mergeHead;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(5);
		
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		ListNode res = m.mergeTwoLists(l1, l2);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}

	}

}
