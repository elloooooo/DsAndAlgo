package designPattern.singleton;

//��������ģʽ
public class Singleton {
	private static final Singleton singleton = new Singleton();
	private Singleton(){
	};
	public static Singleton getSingleton(){
		return singleton;
	}
}
