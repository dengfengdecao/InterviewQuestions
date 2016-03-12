package me.dengfengdecao.function;

import org.junit.Test;

public class UglyNumber {

	/**
	 * 只包含因子2,3,和5的数称作丑数,习惯上把1作为第一个丑数.
	 * 若一个数模2或3或5为0则连续除2或3或5最后结果是1则该数是丑数.
	 * @param index 第index位置上的丑数
	 * @return
	 */
	int getUglyNumberByIndex1(int index) {
		if (index <= 0 ) return 0;
		
		int uglyNumber = 0;	// 丑数
		int uglyFound = 0;
		while (uglyFound < index) {
			uglyNumber++;
			
			if (isUglyNumber(uglyNumber))
				uglyFound++;
			
		}
		
		return uglyNumber;
	}
	
	private boolean isUglyNumber(int number) {
		while (number % 2 == 0)
			number /= 2;
		
		while (number % 3 == 0)
			number /= 3;
		
		while (number % 5 == 0)
			number /= 5;
		
		return number == 1 ? true : false;  
	}
	
	@Test
	public void test1() throws Exception {
		int ugly0 = getUglyNumberByIndex1(0);
		int ugly1 = getUglyNumberByIndex1(1);
		int ugly2 = getUglyNumberByIndex1(2);
		int ugly3 = getUglyNumberByIndex1(3);
		int ugly4 = getUglyNumberByIndex1(4);
		int ugly5 = getUglyNumberByIndex1(5);
		int ugly6 = getUglyNumberByIndex1(6);
		int ugly7 = getUglyNumberByIndex1(7);
		int ugly1500 = getUglyNumberByIndex1(1500);
		System.out.println("test1 ugly0:" + ugly0);
		System.out.println("test1 ugly1:" + ugly1);
		System.out.println("test1 ugly2:" + ugly2);
		System.out.println("test1 ugly3:" + ugly3);
		System.out.println("test1 ugly4:" + ugly4);
		System.out.println("test1 ugly5:" + ugly5);
		System.out.println("test1 ugly6:" + ugly6);
		System.out.println("test1 ugly7:" + ugly7);
		System.out.println("test1 ugly1500:" + ugly1500);
	}
	
}
