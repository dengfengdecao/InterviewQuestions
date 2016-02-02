package me.dengfengdecao.sort;

import org.junit.Test;

public class InsertSort {
	
	/*
	 * 插入排序：先取第一个元素作为已排序序列，再将之后的序列依次和前一位元素比较
	 * 并插入
	 */
	void insertSort(int a[]) {
		if (a == null) return;
		
		for (int i = 1; i < a.length; i++) {	// 从第2个元素开始比较
			int j = i - 1;	// 第i个元素的前一个元素索引
			int tmp = a[i];	// 缓存当前待插入的元素
			while (j >= 0 && a[j] > tmp) {	// 前一元素较大，则将大于待插入元素的元素全部后移一位
				a[j+1] = a[j];
				j--;
			}
			
			// 待插入元素插入当前位置
			a[j+1] = tmp;
			print(a);
		}
		
	}
	public void print(int[] arr) {  
		for (int i = 0; i < arr.length; i++) {  
			System.out.print(arr[i] + "\t");  
		}  
		System.out.println();  
	}  
	
	// 用例1：正常数据
	@Test
	public void test1() {
		int a[] = {49,38,65,97,76,13,27};
		insertSort(a);
	}
	
	// 用例1：有重复数据
	@Test
	public void test2() {
		int a[] = {49,38,65,97,76,13,27,49};
		insertSort(a);
	}

}
