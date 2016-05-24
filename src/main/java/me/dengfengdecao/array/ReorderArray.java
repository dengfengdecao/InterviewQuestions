package me.dengfengdecao.array;

import org.junit.Test;

/**
 * 调整数组的顺序使所有奇数位于偶数前面
 * 定义两个指针start,end分别指向数组首尾,
 * 指针start指向数字不为奇数时,向后移动,指针end指向数字不为
 * 偶数时向前移动,否则交换位置,直到指针end小于start
 * @author linyu
 *
 */
public class ReorderArray {
	
	void reorderOddEven(int[] a, int start, int end) {
		if (a == null) return;
		
		while (start < end) {
			while (start < end && !isEven(a[start]))	// start指向奇数
				start++;
			
			while (start < end && isEven(a[end]))	// end指向偶数
				end--;
			
			if (start < end) {
				int tmp = a[start];
				a[start] = a[end];
				a[end] = tmp;
				
				print(a);
			}						
			
		}
	}

	// 是否是偶数
	boolean isEven(int n) {
		return (n & 0x1) == 0;
	}
	private void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");			
		}
		System.out.println();
	}
	
	// 用例1:正常数据
	@Test
	public void test1() throws Exception {
		int a[] = {1, 2, 3, 4, 5, 6, 7};
		reorderOddEven(a, 0, a.length-1);
	}
	
	// 用例2:所有奇数都在偶数之后
	@Test
	public void test2() throws Exception {
		int a[] = {2, 4, 6, 1, 3, 5, 7};
		reorderOddEven(a, 0, a.length-1);
	}
	
	// 用例3:已分区好,奇数都在偶数之前
	@Test
	public void test3() throws Exception {
		int a[] = {1, 3, 5, 7, 2, 4, 6};
		System.out.println("交换之前");
		print(a);
		reorderOddEven(a, 0, a.length-1);
		System.out.println("交换之后");
		print(a);
	}
	
	// 用例4:只有一个奇数
	@Test
	public void test4() throws Exception {
		int a[] = {1};
		System.out.println("交换之前");
		print(a);
		reorderOddEven(a, 0, a.length-1);
		System.out.println("交换之后");
		print(a);
	}
	
	// 用例5:只有一个偶数
	@Test
	public void test5() throws Exception {
		int a[] = {2};
		System.out.println("交换之前");
		print(a);
		reorderOddEven(a, 0, a.length-1);
		System.out.println("交换之后");
		print(a);
	}
	
	// 用例6:null数据
	@Test
	public void test6() throws Exception {
		reorderOddEven(null, 0, 0);
	}

}
