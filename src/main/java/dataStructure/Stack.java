package dataStructure;

/**
 * @author elloooooo
 * 栈的双链表实现
 * @param <T>
 */
public class Stack<T> {
	
	private Node<T> top;
	private static class Node<T> {
		public T data;
		public Node<T> prev;
		public Node<T> next;

		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			prev = p;
			next = p;
		};

		public Node(T d) {
			data = d;
		}
	}

	public void push(T data) {
		if (top == null) {
			Node<T> node = new Node<T>(data);
			top = node;
		} else {
			Node<T> node = new Node<T>(data);
			top.next = node;
			node.prev = top;
			top = node;
		}
	}

	public Node<T> pop() {
		Node<T> node = top;
		if(top.prev!=null){
			top.prev.next=null;
			top = top.prev;
		}else{
			top = null;
		}
		return node;
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void showStack(){
		Node<T> display = top;
		while(true){
			System.out.println(display.data);
			if(display.prev!=null){
				display = display.prev;
			}else{
				break;
			}
		}
	}
}
