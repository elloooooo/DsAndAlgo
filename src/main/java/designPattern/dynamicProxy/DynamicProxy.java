package designPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 *
 * @param <T>
 * ����������
 */
public class DynamicProxy <T>{
	
	/**
	 * @param loader ���������classLoader
	 * @param interfaces ��������ʵ�ֵĽӿ�
	 * @param h �������������InvocationHandler
	 * @return
	 */
	public static <T>T newProxyInstance(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h){
		return (T)Proxy.newProxyInstance(loader, interfaces, h);
	}

}