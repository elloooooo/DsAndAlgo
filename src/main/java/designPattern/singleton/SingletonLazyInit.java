package designPattern.singleton;

/**
 * @author Administrator
 * 懒汉单例模式
 * 按需生成singleton实例
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
