package designPattern.singleton;

//¼¢ººµ¥ÀýÄ£Ê½
public class Singleton {
	private static final Singleton singleton = new Singleton();
	private Singleton(){
	};
	public static Singleton getSingleton(){
		return singleton;
	}
}
