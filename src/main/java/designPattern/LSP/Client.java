package designPattern.LSP;

import java.util.HashMap;

public class Client {
	public static void main(String[] args) {
		//子类替换父类是，让调用父类的方式，不会引起逻辑变化
		Son f = new Son();
		HashMap map = new HashMap();
		f.doSomething(map);
	}

}
