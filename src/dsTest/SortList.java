package dsTest;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * O(nlogn)�����뵽�ǹ鲢����
 * ��������Ĺ鲢���򣬻���ռ临�Ӷ�Ϊ�������ѣ���ΪҪ��ԭ���鸴��Ϊ���Σ�������merge��������O(n)
 * Ȼ�����������ǿ��Ա�֤�ռ临�Ӷ�Ϊ������
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
		//�洢Ҫ����������ͷ
		ListNode list = null;
		//���ͷԪ��
		if(lList.val<rList.val){
			list = lList;
			lList = lList.next;
		}else{
			list = rList;
			rList = rList.next;
		}
		//�������������ָ��
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
		//���ÿ�������ָ�룬��������м�Ľڵ�
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//���м��֮���һ���㣬�����Ұ��������
		ListNode rList = sortList(slow.next);
		//�м��֮��ضϣ���������������
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
