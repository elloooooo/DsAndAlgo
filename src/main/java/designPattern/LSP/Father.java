package designPattern.LSP;

import java.util.Collection;
import java.util.HashMap;

public class Father {
	public Collection<?> doSomething(HashMap<?, ?> map) {
		System.out.println("���౻ִ��");
		return map.values();
	}
}
