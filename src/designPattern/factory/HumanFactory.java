package designPattern.factory;

public class HumanFactory extends AbstractHumanFactroy {

	@Override
	public <T extends Human> T createHuman(Class<T> c) {
		Human human = null;
		try {
			human = (Human) Class.forName(c.getName()).newInstance();
//			human = c.newInstance();
//			本例中第二种方式也可以，但是利用Class.forName()方法的好处就是可以保证加载要实例化的类，
//			因为newInstance()方法需要类被加载，不像new关键字，如果要实例化的类为加载，会自动加载
//			虽然本例中在调用Class.forName()前，类已经被加载，可能是在传参数是WhiteHuman.class
//			相当于访问类WhiteHuman的静态属性class，这将会导致该类被加载！
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
