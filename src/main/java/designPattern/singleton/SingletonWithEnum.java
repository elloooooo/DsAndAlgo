package designPattern.singleton;

/**
 * 利用单元素枚举实现单例模式
 * 这样的单例模式无偿提供了序列化机制，绝对防止多次实例化
 */
public enum SingletonWithEnum {
	INSTANCE(6) {
		public void someMethod() {
			System.out.println("ok1");
			System.out.println(this.time);
		}
	};
	abstract void someMethod();
	int time;
	SingletonWithEnum(int i){
		this.time = i;
	}
}
