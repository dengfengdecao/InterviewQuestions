package me.dengfengdecao.singleton;

/**
 * 懒汉式
 * 非线程安全
 * @author linyu
 *
 */
public class Singleton2 {
	
	private static Singleton2 object;

	private Singleton2() {
	}
	
	public static Singleton2 newInstance() {
		if (object == null) {
			object = new Singleton2();
		}
		
		return object;
	}
}
