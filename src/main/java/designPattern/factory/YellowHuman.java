package designPattern.factory;

public class YellowHuman implements Human {

	@Override
	public void getcolor() {
		System.out.println("黄种人是黄的");

	}

	@Override
	public void talk() {
		System.out.println("黄种人说话双字节");
	}

}
