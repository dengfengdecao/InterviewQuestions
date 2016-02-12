package me.dengfengdecao.function;

import org.junit.Test;

/**
 * 数值的整数次方
 * 
 * 求a的n次方公式: 
 * a^n = a^n/2 * a^n/2(n是偶数)
 * a^n = a^(n-1)/2 * a^(n-1)/2 * a(n是奇数)
 * @author linyu
 *
 */
public class Power {

	double power(double base, int exponent) {
		boolean invalidInput;	// 是否是有效输入数据
		
		if (equal(base, 0.0) && exponent <= 0) {	// 底数为0并且指数不大于0
			invalidInput = true;
			return 0.0;
		}
		
		int absExponent = exponent < 0 ? -exponent : exponent;	// 求指数的绝对值
		double result = powerWithAbsExponent(base, absExponent);
		
		if (exponent < 0)
			result = 1.0 / result;	// 指数为负数,则其绝对值的次方的倒数是其值
			
		return result;
	}

	private double powerWithAbsExponent(double base, int absExponent) {
		// 指数为0和1
		if (absExponent == 0)
			return 1;
		if (absExponent == 1)
			return base;
		
		// 递归并保存次方值
		double result = powerWithAbsExponent(base, absExponent >> 1);	// 右移代替除以2
		result *= result;
		if ((absExponent & 0x1) == 1)	// 逻辑与,与1等于1则为奇数否则为偶数
			result *= base;
		
		return result;
	}

	private boolean equal(double base, double d) {
		// 比较两个double的值是否相等
		// 由于计算机的小数(float和double型小数)都有误差,所以不能用==比较大小,而比较两个
		// 差值的绝对值很小(如:0.0000001),就可以认为两个小数相等.
		if (base - d < 0.0000001 && base - d > -0.0000001) {
			return true;
		} else {
			return false;			
		}
	}
	
	// ====================测试代码====================
	public static void main(String[] args) {
		// 底数、指数都为正数
		Power p = new Power();		
		p.printf(p.power(0, -4) + "");
	}
	
	@Test
	public void test1() throws Exception {
		// 底数、指数都为正数
		printf("Test1 begins.\n" + power(2, 3));
	}

	@Test
	public void test7() {
		// 底数为0、指数为负数
		printf("Test7 begins.\n" + power(0, -4));

	}

	@Test
	public void test6() {
		// 底数为0、指数为正数
		printf("Test6 begins.\n" + power(0, 4));
	}

	@Test
	public void test5() {
		// 底数、指数都为0
		printf("Test5 begins.\n" + power(0, 0));
	}

	@Test
	public void test4() {
		// 指数为0
		printf("Test4 begins.\n" + power(2, 0));
	}

	@Test
	public void test3() {
		// 指数为负数
		printf("Test3 begins.\n" + power(2, -3));
	}

	@Test
	public void test2() {
		// 底数为负数、指数为正数
		printf("Test2 begins.\n" + power(-2, 3));
	}

	@Test
	private void printf(String s) {
		System.out.print(s);
	}
}
