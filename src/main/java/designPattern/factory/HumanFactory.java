package designPattern.factory;

public class HumanFactory extends AbstractHumanFactroy {

	@Override
	public <T extends Human> T createHuman(Class<T> c) {
		Human human = null;
		try {
			human = (Human) Class.forName(c.getName()).newInstance();
//			human = c.newInstance();
//			�����еڶ��ַ�ʽҲ���ԣ���������Class.forName()�����ĺô����ǿ��Ա�֤����Ҫʵ�������࣬
//			��ΪnewInstance()������Ҫ�౻���أ�����new�ؼ��֣����Ҫʵ��������Ϊ���أ����Զ�����
//			��Ȼ�������ڵ���Class.forName()ǰ�����Ѿ������أ��������ڴ�������WhiteHuman.class
//			�൱�ڷ�����WhiteHuman�ľ�̬����class���⽫�ᵼ�¸��౻���أ�
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return (T) human;
	}

}
