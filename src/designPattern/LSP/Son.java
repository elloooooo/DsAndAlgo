package designPattern.LSP;

import java.util.Collection;
import java.util.Map;

public class Son extends Father{
	//子类重载父类的方法，参数范围应当扩大
	public Collection<?> doSomething(Map<?, ?> map) {
		System.out.println("子类被执行");
		return map.values();
	}
}
