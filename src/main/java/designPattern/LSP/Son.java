package designPattern.LSP;

import java.util.Collection;
import java.util.Map;

public class Son extends Father{
	//�������ظ���ķ�����������ΧӦ������
	public Collection<?> doSomething(Map<?, ?> map) {
		System.out.println("���౻ִ��");
		return map.values();
	}
}
