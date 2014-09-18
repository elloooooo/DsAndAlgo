package dsTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用两个队列实现一个栈
 **/
public class TwoQueueStack<T> {

	private Queue<T> q1 = new LinkedList<T>();
	private Queue<T> q2 = new LinkedList<T>();
	private Queue<T> tmp = q1;

	public void push(T object) {
		this.tmp.add(object);
	}

	public T pop() {
		Queue<T> _tmp = null;
		if (tmp.equals(q1)) {
			_tmp = q2;
		} else {
			_tmp = q1;
		}

		while (tmp.size() > 1) {
			_tmp.add(tmp.poll());
		}

		T object = tmp.poll();
		tmp = _tmp;
		return object;
	}

}
