package dataStructure;


/**
 * @author elloooooo
 * 给一般的双链表栈实现，加入一个辅助栈，存放栈的最小值
 * 
 * 数据push时，如果数据不已有的数据小，则入栈；否则，不入栈
 * 
 * 数据pop时，检测pop的数据是否在辅助栈顶，如果是，怎将其出栈
 * 
 * 则任何时候可以获得最小值
 *
 */
public class StackWithMin{
	private Node top;
	private Node minNode;
	private static class Node {
		public int data;
		public Node prev;
		public Node next;

		public Node(int d, Node p, Node n) {
			data = d;
			prev = p;
			next = p;
		};

		public Node(int d) {
			data = d;
		}
	}

	public void push(int data) {
		if (top == null) {
			Node node = new Node(data);
			top = node;
			
			minNode = node;
		} else {
			Node node = new Node(data);
			top.next = node;
			node.prev = top;
			top = node;
			
			if(data<minNode.data){
				minNode.next = node;
				node.prev = minNode;
				minNode = node;
			}
		}
	}

	public Node pop() {
		Node node = top;
		if(top.data==minNode.data){
			if(minNode.prev!=null){
				minNode.prev.next = null;
				minNode = minNode.prev;
			}else{
				minNode = null;
			}
		}
		
		if(top.prev!=null){
			top.prev.next=null;
			top = top.prev;
		}else{
			top = null;
		}
		return node;
	}

	public int min(){
		if(minNode!=null){
			return minNode.data;
		}else{
			return -1;
		}
	}
	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	
	
	
	public static void main(String[] args) {
		StackWithMin stackWithMin = new StackWithMin();
		stackWithMin.push(5);
		stackWithMin.push(2);
		stackWithMin.push(3);
		stackWithMin.push(1);
		
    	stackWithMin.pop();
		/*while (true) {
			if (!stackWithMin.isEmpty()) {
				int val = stackWithMin.pop().data;
				System.out.println(val);
			} else {
				break;
			}
		}*/
		
/*		while (true) {
			if (stackWithMin.minNode!=null) {
				int val = stackWithMin.min();
				System.out.println(val);
				stackWithMin.minNode = stackWithMin.minNode.prev;
			} else {
				break;
			}
		}
*/		
		System.out.println("最小的数字：");
		System.out.println(stackWithMin.min());
	}

}
