package designPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 *
 * @param <T>
 * 产生代理类
 */
public class DynamicProxy <T>{
	
	/**
	 * @param loader 被代理类的classLoader
	 * @param interfaces 被代理类实现的接口
	 * @param h 代理被代理类的InvocationHandler
	 * @return
	 */
	public static <T>T newProxyInstance(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h){
		return (T)Proxy.newProxyInstance(loader, interfaces, h);
	}

}
