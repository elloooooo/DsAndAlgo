package dsTest;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * O(nlogn)可以想到是归并排序
 * 对于数组的归并排序，或许空间复杂度为常数很难，因为要将原数组复制为两段，最后进行merge，所以是O(n)
 * 然而对于链表，是可以保证空间复杂度为常数的
 * 
 */
/**
 * Definition for singly-linked list. 
 * class ListNode { 
 * 	int val; 
 * 	ListNode next;
 * 	ListNode(int x) { 
 * 		val = x; 
 * 		next = null; 
 * 	} 
 * }
 */
public class SortList {
	private static class ListNode { 
		 	int val; 
		 	ListNode next;
		  	ListNode(int x) { 
		  		val = x; 
		  		next = null; 
		  	} 

	}
	
	private ListNode merge(ListNode lList,ListNode rList){
		//存储要输出的链表的头
		ListNode list = null;
		//获得头元素
		if(lList.val<rList.val){
			list = lList;
			lList = lList.next;
		}else{
			list = rList;
			rList = rList.next;
		}
		//遍历整个链表的指针
		ListNode cur = list;
	
		while(lList!=null&&rList!=null){
			if(lList.val<rList.val){
				cur.next = lList;
				lList = lList.next;
			}else{
				cur.next = rList;
				rList = rList.next;
			}
			cur = cur.next;
		}
		if(lList==null&&rList!=null){
			cur.next = rList;
		}else if(lList!=null&&rList==null){
			cur.next = lList;
		}
		return list;
	}
	
	public ListNode sortList(ListNode head) {
		if(head==null){
			return null;
		}
		if(head.next==null){
			return head;
		}
		//利用快慢两个指针，获得链表中间的节点
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//从中间点之后的一个点，属于右半边子序列
		ListNode rList = sortList(slow.next);
		//中间点之后截断，属于左半边子序列
		slow.next = null;
		ListNode lList = sortList(head);
		
        return merge(lList, rList);
    }
	public static void main(String[] args) {
		ListNode lList = new ListNode(2);
		lList.next = new ListNode(7);
		lList.next.next = new ListNode(5);
		
		ListNode rList = new ListNode(2);
		rList.next = new ListNode(4);
		
		SortList s = new SortList();
		ListNode l = s.sortList(lList);
		
		
		while(l!=null){
			System.out.println(l.val);
			l = l.next;
		}
	}
}
