package dsTest;


/**
 * 剑指Offer
 * 在O(1)内删除链表中的一个节点
 */
public class RemoveNodeFromList {
	
	public static void removeNode(ListNode head,ListNode nodeToDelete){
		if(nodeToDelete.next!=null){
			//带删除节点后面仍有节点
			//将后一个节点的值复制给该节点，并删除后一个节点
			nodeToDelete.val = nodeToDelete.next.val;
			nodeToDelete.next = nodeToDelete.next.next;
		}else{
			//如果待删除节点后面没有节点
			//如果带删除节点时头节点
			if(head.equals(nodeToDelete)){
				head =null;
			}else{
				//如果不是头节点，从头顺序遍历，找到要删除节点前面一个节点
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
