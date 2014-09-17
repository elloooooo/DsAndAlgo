package designPattern.factory;

public abstract class AbstractHumanFactroy {
	public abstract <T extends Human> T createHuman(Class<T> c);
}
