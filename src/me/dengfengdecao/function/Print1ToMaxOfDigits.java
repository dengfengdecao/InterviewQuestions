package me.dengfengdecao.function;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 打印1到最大的n位数
 * 
 * 思路:在数字前面补0,发现n位所有十进制数实际上是n个从0到9的全排列.
 * 例:001,002,...,110,...,220,...,330,...,440,...,550,...660,...770,...880,...990
 * @author linyu
 *
 */
public class Print1ToMaxOfDigits {

	void print1ToMaxOfNDigits(int n) {
		if (n <= 0)
			return;
		
		int[] num = new int[n];
		for (int i = 0; i < 10; i++) {	
			num[0] = i;	// 初始化数组的第一位,即前面补0,若n>1,则遍历10次后首位进位1
			print1ToMaxOfNDigitsRecursively(num, n, 0);
		}
		
	}
	
	// 用递归实现全排列
	void print1ToMaxOfNDigitsRecursively(int[] num, int n, int idx) {
		if (idx == n-1) {	// 数组索引idx等于n位减1,则打印该数字
			printNumber(num); // 从1开始打印到最大n位数
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			num[idx + 1] = i;	// 初始化数组的下一位
			print1ToMaxOfNDigitsRecursively(num, n, idx+1);	// 递归计算下一位
		}				
	}

	// 打印数字,数字前面的0不打印
	private void printNumber(int[] num) {
		boolean isBegin0 = true;
		for (int i = 0; i < num.length; i++) {
			if (isBegin0 && num[i] != 0) 
				isBegin0 = false;
			
			if (!isBegin0) 
				System.out.print(num[i]);
		}		
		
		System.out.print(", ");	
		
	}
	
	@Test
	public void test1() throws Exception {
		print1ToMaxOfNDigits(1);
	}
	
	@Test
	public void test2() throws Exception {
		print1ToMaxOfNDigits(2);
	}
	
	@Test
	public void test3() throws Exception {
		print1ToMaxOfNDigits(3);
	}
	
	@Test
	public void test4() throws Exception {
		print1ToMaxOfNDigits(0);
	}
	
	@Test
	public void test5() throws Exception {
		print1ToMaxOfNDigits(-1);
	}
}
