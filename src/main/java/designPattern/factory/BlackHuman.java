package designPattern.factory;

public class BlackHuman implements Human {

	@Override
	public void getcolor() {
		System.out.println("黑种人是黑的");
	}

	@Override
	public void talk() {
		System.out.println("黑人说话听不懂");

	}

}
