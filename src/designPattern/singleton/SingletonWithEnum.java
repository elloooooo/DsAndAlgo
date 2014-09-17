package designPattern.singleton;

/**
 * ���õ�Ԫ��ö��ʵ�ֵ���ģʽ
 * �����ĵ���ģʽ�޳��ṩ�����л����ƣ����Է�ֹ���ʵ����
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
