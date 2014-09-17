package dataStructure;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;

	}
	
	@Override
	public String toString(){
		StringBuffer sbf = new StringBuffer();
		
		ListNode cur = this;
		while (cur!= null) {
			sbf.append(cur.val);
			sbf.append(" ");
			cur = cur.next;
		}
		
		return sbf.toString().trim();
	}
}
