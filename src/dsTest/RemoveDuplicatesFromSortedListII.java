package dsTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		Set<Integer> valToRemove = new HashSet<Integer>();
		ListNode cur = head;
		while(cur!=null){
			if(cur.next!=null&&cur.val == cur.next.val){
				valToRemove.add(cur.val);
			}
			cur = cur.next;
		}
		ListNode fake = new ListNode(0);
		fake.next = head;
		cur = fake;
		while(cur.next!=null){
			if(valToRemove.contains(cur.next.val)){
				cur.next = cur.next.next;
				continue;
			}
			cur = cur.next;
		}
		return fake.next;
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(1);
		
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(4);
		
		RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
		ListNode res = r.deleteDuplicates(root);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}

	}

}
