package designPattern.LSP;

import java.util.HashMap;

public class Client {
	public static void main(String[] args) {
		//�����滻�����ǣ��õ��ø���ķ�ʽ�����������߼��仯
		Son f = new Son();
		HashMap map = new HashMap();
		f.doSomething(map);
	}

}
