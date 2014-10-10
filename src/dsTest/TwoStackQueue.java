package dsTest;

import java.util.Stack;

/**
 * @author Administrator
 * ������ջʵ��һ������
 */
public class TwoStackQueue<T> {
	private Stack<T> stackIn = new Stack<T>();
	private Stack<T> stackOut = new Stack<T>();
	
	public void push(T obj){
		stackIn.add(obj);
	}
	
	public T pop(){
		if(stackOut.isEmpty()){
			while(!stackIn.isEmpty()){
				stackOut.add(stackIn.pop());
			}
		}
		return stackOut.pop();
	}
	
	public static void main(String[] args) {
	}

}
