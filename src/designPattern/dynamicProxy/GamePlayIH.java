package designPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * InvocationHandler的实现类，它负责承担被代理对象的方法调用
 */
public class GamePlayIH implements InvocationHandler {
	Object obj = null;
	public GamePlayIH(Object _obj){
		this.obj = _obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = method.invoke(this.obj, args);
		return result;
	}
	
}
