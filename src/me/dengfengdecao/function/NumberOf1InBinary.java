package me.dengfengdecao.function;

import org.junit.Test;

/**
 * 一个整数的二进制表示中1的个数
 * @author linyu
 *
 */
public class NumberOf1InBinary {
	
	// 把一个整数减去1,再和原整数做与运算,会把该整数最右边一个1变成0.那么一个整数
	// 的二进制表示中有多少个1,就进行多少次这样的操作.
	// 例:8=1000,8-1=7=0111,1000&0111=0000
	int numberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		
		return count;
	}

	@Test
	public void test() throws Exception {
		 // 输入0，期待的输出是0
		int c0 = numberOf1(0);
		System.out.println("test1:c0=" + c0);

	    // 输入1，期待的输出是1
		int c1 = numberOf1(1);
		System.out.println("test1:c1=" + c1);

		// 输入10，期待的输出是2
		int c2 = numberOf1(10);
		System.out.println("test1:c2=" + c2);

		// 输入0x7FFFFFFF，期待的输出是31
		int c3 = numberOf1(0x7FFFFFFF);
		System.out.println("test1:c3=" + c3);

		// 输入0xFFFFFFFF（负数），期待的输出是32
		int c4 = numberOf1(0xFFFFFFFF);
		System.out.println("test1:c4=" + c4);

		// 输入0x80000000（负数），期待的输出是1
		int c5 = numberOf1(0x80000000);
		System.out.println("test1:c5=" + c5);
	}
}
