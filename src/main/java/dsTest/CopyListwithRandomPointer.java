package dsTest;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */

/**
 * Answer:
 * 本题的技巧在于如何在原链表元素的random指针所指元素还没有被复制时，将复制的元素的random指针指过去！
 * 十分巧妙地将每一个元素复制后，添加在原元素的后面，而新增元素的random指针指向原链表中对应的元素，可以说是寄存一下，
 * 等所有的元素都复制好了，只要将random->next给新增元素，就ok了！
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
		//在每一个元素后面生成它自己的复制节点
		while(cur!=null){
			tmp = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = tmp;
			
			cur.next.random = (cur.random==null)?null:cur.random;
			
			cur = tmp;
		}
		//将新增元素的random指针，由指向原链表中的元素改为指向对应新增元素
		cur = head.next;
		while(cur!=null){
			cur.random = (cur.random!=null)?cur.random.next:null;
			cur = (cur.next!=null)?cur.next.next:null;
		}
		//将原链表还原，同时也将新增链表抽离出来
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
