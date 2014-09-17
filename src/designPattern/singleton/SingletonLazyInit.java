package designPattern.singleton;

/**
 * @author Administrator
 * ��������ģʽ
 */
public class SingletonLazyInit {
	private SingletonLazyInit(){}
	
	private static final class Holder{
		static final SingletonLazyInit instance = new SingletonLazyInit();
	}
	
	public static SingletonLazyInit getInstence(){
		return Holder.instance;
	}
}
