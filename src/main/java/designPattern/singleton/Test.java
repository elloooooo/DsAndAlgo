package designPattern.singleton;

/**
 * 使用枚举实现的单例模式
 */
public class Test {
	public static void main(String[] args) {
		SingletonWithEnum e = SingletonWithEnum.INSTANCE;
		e.someMethod();
	}

}
