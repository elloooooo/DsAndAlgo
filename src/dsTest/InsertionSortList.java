package dsTest;

/**
 * Sort a linked list using insertion sort.
 * 
 * ���������Ǽ���ǰn-1�������Ѿ��ź���ȡ��n����Ȼ�������ǰn-1������ȷ��λ��
 * 
 * ��Ѱ��ȷ��λ�ã�����������˵�����ǽ���n�����������Լ���ߵ����ֱȽϣ������ߵ����Ƚϴ���������һλ
 * 
 * Ȼ�����ڵ����б���ԣ������޷����ǰһ��Ԫ�أ�ֻ��ָ���һ��Ԫ�ص�����������Ҫ����һ��tmpָ�룬���ָ��ÿ�δ���ͷ���Ѱ�����ڵ�n��Ԫ�ص���ȷλ��
 * 
 * ����ĿҪ���۵�Ԫ��һֱ��cur.next,���ڱȽϵ�Ԫ��Ҳ��tmp.next��֮����������Ϊ�ˣ��������޸����ǣ����Ի������Ԫ��ǰһ��Ԫ�ص�����
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
			//tmp���Ǹ��ڱ�Ԫ�ذɣ�������һ��Ԫ��ָ��head
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
				//���Ҫ������Ԫ�صĵط�ԭ����head����Ҫ��һ��headָ��
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
