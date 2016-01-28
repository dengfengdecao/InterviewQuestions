package me.dengfengdecao.singleton;

/**
 * 集合懒汉和饿汉式的优点
 * 线程安全
 * @author linyu
 *
 */
public class Singleton3 {

	/*
	 *  内部类，用于实现lazy机制
	 *  内部类加载的时候实例化一次object。
	 */
	static class SingletonHolder {
		private static final Singleton3 object = new Singleton3(); 
	}

	private Singleton3() {

	}
	
	public static Singleton3 newInstance() {
		return SingletonHolder.object;
	}
	
}
