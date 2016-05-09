package designPattern.dynamicProxy;

/**
 * @author Administrator
 * 要代理的接口
 */
public interface IGamePlayer {
	
	public void login(String user,String password); 
	public void killBoss();
	public void upgrade();


}
