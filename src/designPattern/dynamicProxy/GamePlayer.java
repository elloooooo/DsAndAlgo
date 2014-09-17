package designPattern.dynamicProxy;

/**
 * @author Administrator
 * 被代理对象
 */
public class GamePlayer implements IGamePlayer {
	private String name = "";
	private String password = "";

	@Override
	public void login(String user, String password) {
		this.name = user;
		this.password = password;
	}

	@Override
	public void killBoss() {
		System.out.println(this.name + "is killing boss!");
	}

	@Override
	public void upgrade() {
		System.out.println(this.name + " upgrades!");
	}

}
