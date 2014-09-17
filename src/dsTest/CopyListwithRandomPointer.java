package dsTest;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */

/**
 * Answer:
 * ����ļ������������ԭ����Ԫ�ص�randomָ����ָԪ�ػ�û�б�����ʱ�������Ƶ�Ԫ�ص�randomָ��ָ��ȥ��
 * ʮ������ؽ�ÿһ��Ԫ�ظ��ƺ������ԭԪ�صĺ��棬������Ԫ�ص�randomָ��ָ��ԭ�����ж�Ӧ��Ԫ�أ�����˵�ǼĴ�һ�£�
 * �����е�Ԫ�ض����ƺ��ˣ�ֻҪ��random->next������Ԫ�أ���ok�ˣ�
 */
public class CopyListwithRandomPointer {
	private static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null){
			return head;
		}
		RandomListNode cur = head;
		RandomListNode tmp = null;
		//��ÿһ��Ԫ�غ����������Լ��ĸ��ƽڵ�
		while(cur!=null){
			tmp = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = tmp;
			
			cur.next.random = (cur.random==null)?null:cur.random;
			
			cur = tmp;
		}
		//������Ԫ�ص�randomָ�룬��ָ��ԭ�����е�Ԫ�ظ�Ϊָ���Ӧ����Ԫ��
		cur = head.next;
		while(cur!=null){
			cur.random = (cur.random!=null)?cur.random.next:null;
			cur = (cur.next!=null)?cur.next.next:null;
		}
		//��ԭ����ԭ��ͬʱҲ����������������
		RandomListNode copyHead = head.next;
		cur = head;
		while(cur!=null){
			tmp = cur.next;
			cur.next = (cur.next!=null)?cur.next.next:null;
			cur = tmp;
		}
		return copyHead;
	}

	public static void main(String[] args) {
		RandomListNode r = new RandomListNode(1);
		r.next = new RandomListNode(2);
		r.next.next = new RandomListNode(3);
		r.random = r.next.next;
		
		CopyListwithRandomPointer c = new CopyListwithRandomPointer();
		RandomListNode copy = c.copyRandomList(r);
		
		while(copy!=null){
			System.out.println(copy.label);
			System.out.println(copy.random!=null?copy.random.label:0);
			copy = copy.next;
		}

	}

}
