package designPattern.factory;

public class WhiteHuman implements Human {

	@Override
	public void getcolor() {
		System.out.println("白人是白的");
	}

	@Override
	public void talk() {
		System.out.println("白人说英语");
	}

}
