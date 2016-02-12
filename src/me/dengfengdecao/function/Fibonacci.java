package me.dengfengdecao.function;

import org.junit.Test;

/**
 * 斐波那契
 * @author linyu
 *
 */
public class Fibonacci {

	// 递归:有重复计算的,效率低,由于递归调用函数会消耗性能,所以性能不高
	int fibonacci_recursion(int n) {
		if (n <= 0)
			return 0;
		
		if (n == 1)
			return 1;
		
	    return fibonacci_recursion(n-1) + fibonacci_recursion(n-2);
			
	}
	
	// 迭代
	int fibonacci(int n) {
		int result[] = {0, 1};
		if (n < 2)
			return result[n];
		
		int f1 = 1;
		int f2 = 0;
		int fn = 0;
		for (int i = 2; i <= n; i++) {
			fn = f1 + f2;
			f2 = f1;					
			f1 = fn;	// 保存
		}
		
		return fn;
	}
	
	@Test
	public void test1() throws Exception {
		int result0 = fibonacci_recursion(0);
		int result1 = fibonacci_recursion(1);
		int result2 = fibonacci_recursion(2);
		int result3 = fibonacci_recursion(10);
		int result4 = fibonacci_recursion(40);
		System.out.println("test1:" + result0);
		System.out.println("test1:" + result1);
		System.out.println("test1:" + result2);
		System.out.println("test1:" + result3);
		System.out.println("test1:" + result4);
	}
	
	@Test
	public void test2() throws Exception {
		int result0 = fibonacci_recursion(0);
		int result1 = fibonacci_recursion(1);
		int result2 = fibonacci_recursion(2);
		int result3 = fibonacci_recursion(10);
		int result4 = fibonacci_recursion(40);
		System.out.println("test2:" + result0);
		System.out.println("test2:" + result1);
		System.out.println("test2:" + result2);
		System.out.println("test2:" + result3);
		System.out.println("test2:" + result4);
	}
}
