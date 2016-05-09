package dataStructure;

public class LinkedList<T> {
	public Node head;
	public Node tail;
	private static class Node<T>{
		private T data;
		private Node next;
	}
	
	public LinkedList(T data){
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = tail;
		this.head = node;
	}
	
	public LinkedList(){
		
	}
	public void insert(int i){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
