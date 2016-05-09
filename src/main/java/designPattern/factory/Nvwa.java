package designPattern.factory;

public class Nvwa {
	public static void main(String[] args) {
		AbstractHumanFactroy Yinyanglu = new HumanFactory();
		System.out.println("--造白人--");
		Human whiteHuman = Yinyanglu.createHuman(WhiteHuman.class);
		whiteHuman.getcolor();
		whiteHuman.talk();
		System.out.println("--造黑人--");
		Human blackHuman = Yinyanglu.createHuman(BlackHuman.class);
		blackHuman.getcolor();
		blackHuman.talk();
	}

}
