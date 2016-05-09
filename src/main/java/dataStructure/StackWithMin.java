package dataStructure;


/**
 * @author elloooooo
 * ��һ���˫����ջʵ�֣�����һ������ջ�����ջ����Сֵ
 * 
 * ����pushʱ��������ݲ����е�����С������ջ�����򣬲���ջ
 * 
 * ����popʱ�����pop�������Ƿ��ڸ���ջ��������ǣ��������ջ
 * 
 * ���κ�ʱ����Ի����Сֵ
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
		System.out.println("��С�����֣�");
		System.out.println(stackWithMin.min());
	}

}
