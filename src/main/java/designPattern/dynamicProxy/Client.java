package designPattern.dynamicProxy;


public class Client {
	public static void main(String[] args) {
		IGamePlayer player = new GamePlayer();
		GamePlayIH gamePlayHandler = new GamePlayIH(player);
		
		IGamePlayer proxy = DynamicProxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), gamePlayHandler);
		proxy.login("Ollie", "123");
		proxy.killBoss();
	}

}
