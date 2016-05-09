package dsTest;

/**
 * @author elloooooo 
 */
public class IsLinkedListCycle {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * Follow up: Can you solve it without using extra space?
	 * Answer:
	 * ��������ָ�룬һ���죬һ�������������ָ������غϣ���˵���л�
	*/
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode oneStepNode = head;
		ListNode twoStepNode = head;
		boolean flag = false;
		while (oneStepNode.next != null && twoStepNode.next != null
				&& twoStepNode.next.next != null) {
			oneStepNode = oneStepNode.next;
			twoStepNode = twoStepNode.next.next;
			if (oneStepNode.equals(twoStepNode)) {
				flag = true;
				break;
			}
		}
		return flag;

	}

	/**
	 * Given a linked list, return the node where the cycle begins. 
	 * If there is no cycle, return null.
	 * Answer:
	 * ��һ������ָ������ʱ������һ���µ���ָ�룬��head��ʼ�ߣ���oneStepNode����ʱ����ָ��ʹ��ڻ������
	 * 
	 */
	public static ListNode detectCycle(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode oneStepNode = head;
		ListNode twoStepNode = head;
		
		while(oneStepNode.next!=null&&twoStepNode.next!=null&&twoStepNode.next.next!=null){
			oneStepNode = oneStepNode.next;
			twoStepNode = twoStepNode.next.next;
			if(oneStepNode.equals(twoStepNode)){
				ListNode findCycleHead = head;
				while(oneStepNode.next!=null){
					if(oneStepNode.equals(findCycleHead)){
						return findCycleHead;
					}
					oneStepNode = oneStepNode.next;
					findCycleHead = findCycleHead.next;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] data = { -21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6,
				29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5 };

		ListNode head = new ListNode(data[0]);
		ListNode node = head;
		for (int i = 1; i < data.length; i++) {
			node.next = new ListNode(data[i]);
			node = node.next;
		}
		
		// �����л�
		node.next = head;
		
//		System.out.println(IsLinkedListCycle.hasCycle(head));
		System.out.println(IsLinkedListCycle.detectCycle(head).val);

	}

}
