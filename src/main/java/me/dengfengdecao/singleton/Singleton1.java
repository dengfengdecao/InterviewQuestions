package me.dengfengdecao.singleton;

/**
 * 饿汉式
 * 线程安全
 * http://blog.csdn.net/cdh1213/article/details/40819235
 * @author linyu
 *
 */
public class Singleton1 {
	
	private static final Singleton1 object = new Singleton1();

	private Singleton1() {

	}
	
	// 调用静态函数时初始化静态变量
	public static Singleton1 newInstance() {
		return object;
	}
	
	

}
