package dsTest;


/**
 * ��ָOffer
 * ��O(1)��ɾ�������е�һ���ڵ�
 */
public class RemoveNodeFromList {
	
	public static void removeNode(ListNode head,ListNode nodeToDelete){
		if(nodeToDelete.next!=null){
			//��ɾ���ڵ�������нڵ�
			//����һ���ڵ��ֵ���Ƹ��ýڵ㣬��ɾ����һ���ڵ�
			nodeToDelete.val = nodeToDelete.next.val;
			nodeToDelete.next = nodeToDelete.next.next;
		}else{
			//�����ɾ���ڵ����û�нڵ�
			//�����ɾ���ڵ�ʱͷ�ڵ�
			if(head.equals(nodeToDelete)){
				head =null;
			}else{
				//�������ͷ�ڵ㣬��ͷ˳��������ҵ�Ҫɾ���ڵ�ǰ��һ���ڵ�
				ListNode cur = head;
				while(cur.next.equals(nodeToDelete)){
					cur = cur.next;
				}
				cur.next = null;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
