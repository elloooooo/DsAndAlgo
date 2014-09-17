package dsTest;

/**
 * Sort a linked list using insertion sort.
 * 
 * 插入排序是假设前n-1个数字已经排好序，取第n个，然后将其放入前n-1数中正确的位置
 * 
 * 找寻正确的位置，对于数组来说，就是将第n个数依次与自己左边的数字比较，如果左边的数比较大，则将其右移一位
 * 
 * 然而对于单项列表而言，由于无法获得前一个元素（只有指向后一个元素的链），所以要创建一个tmp指针，这个指针每次从列头向后寻找属于第n个元素的正确位置
 * 
 * 本题目要讨论的元素一直是cur.next,用于比较的元素也是tmp.next，之所以这样是为了，可以在修改链是，可以获得讨论元素前一个元素的引用
 * 
 */
public class InsertionSortList {
	private static class ListNode { 
	 	int val; 
	 	ListNode next;
	  	ListNode(int x) { 
	  		val = x; 
	  		next = null; 
	  	} 

}
	public ListNode insertionSortList(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode cur = head;
		while(cur.next!=null){
			//tmp算是个哨兵元素吧，它的下一个元素指向head
			ListNode tmp = new ListNode(0);
			tmp.next = head;
			while(cur.next.val>tmp.next.val){
				tmp = tmp.next;
			}
			if(!cur.next.equals(tmp.next)){
				ListNode swap = cur.next;
				if(swap.next!=null){
					cur.next = swap.next;
				}else{
					cur.next = null;
				}
				swap.next = tmp.next;
				//如果要插入新元素的地方原先是head，则要更一下head指针
				if(tmp.next.equals(head)){
					head = swap;
				}
				tmp.next = swap;
			}else{
				cur = cur.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode lList = new ListNode(2);
		lList.next = new ListNode(5);
		lList.next.next = new ListNode(2);
		lList.next.next.next= new ListNode(2);
		lList.next.next.next.next = new ListNode(4);
		
		InsertionSortList i = new InsertionSortList();
		ListNode l = i.insertionSortList(lList);
		while(l!=null){
			System.out.println(l.val);
			l = l.next;
		}
	}

}
