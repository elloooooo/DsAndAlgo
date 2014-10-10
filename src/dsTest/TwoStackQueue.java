package dsTest;

import java.util.Stack;

/**
 * @author Administrator
 * 用两个栈实现一个队列
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
