package designPattern.singleton;

/**
 * ʹ��ö��ʵ�ֵĵ���ģʽ
 */
public class Test {
	public static void main(String[] args) {
		SingletonWithEnum e = SingletonWithEnum.INSTANCE;
		e.someMethod();
	}

}
