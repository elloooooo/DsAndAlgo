package dsTest;

/**
 *  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	
	You must do this in-place without altering the nodes' values.
	
	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}
 */
/**
 * 利用快慢指针获得链表中点，将链表一分为二
 * 
 * 将后面一段链表反转（中点）
 * 
 * 与前面一段链表merge
 *
 */
public class ReorderList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public void reorderList(ListNode head) {
		if(head==null||head.next==null){
			return;
		}
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode rsubList = slow.next;
        slow.next = null;
        ListNode lsubList = head;
        rsubList = reverseListDirection(rsubList);
        
        merage(lsubList,rsubList);
        
        
    }
	
	private void merage(ListNode lsubList, ListNode rsubList) {
		ListNode cur = lsubList;
		lsubList = lsubList.next;
		
		while(rsubList!=null){
			cur.next = rsubList;
			rsubList = rsubList.next;
			
			cur = cur.next;
			if(lsubList!=null){
				cur.next = lsubList;
				lsubList = lsubList.next;
				cur = cur.next;
			}
		}
	}

	private ListNode reverseListDirection(ListNode head){
		if(head==null){
			return null;
		}
		if(head.next==null){
			return head;
		}
		
		ListNode cur = head.next;
		ListNode preReverse;
		
		if(head.next.next!=null){
			preReverse = head.next.next;
			head.next = null;
			
			while(preReverse!=null){
				cur.next = head;
				head = cur;
				cur = preReverse;
				preReverse = preReverse.next;
			}
			
			cur.next = head;
			head = cur;
			
		}else{
			cur.next = head;
			head.next = null;
			head = cur;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode t = new ListNode(1);
		t.next = new ListNode(2);
		t.next.next = new ListNode(3);
		t.next.next.next = new ListNode(4);
		t.next.next.next.next = new ListNode(5);
		ReorderList r = new ReorderList();
		r.reorderList(t);
		
		while(t!=null){
			System.out.println(t.val);
			t = t.next;
		}
	}

}
