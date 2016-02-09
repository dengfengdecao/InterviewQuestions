package me.dengfengdecao.sort;

import org.junit.Test;

public class SelectionSort {

	/*
	 * 选择排序:首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
	 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
	 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
	 */		
	void selectionSort(int arr[]) {
		int i, j, min, temp, len = arr.length;
		for (i = 0; i < len; i++) {
			min = i;
			for (j = i + 1; j < len; j++) {	// 遍历数组找出最小元素索引
				if (arr[min] > arr[j])
					min = j;				
			}
			
			temp = arr[min];	// 缓存最小元素
			arr[min] = arr[i];  // 和最小元素交换  
			arr[i] = temp;
			
			print(arr);
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
		int a[] = {4,3,5,1,6,2,7,0,9,8};
		selectionSort(a);
	}
	
	// 用例2：有重复数据
	@Test
	public void test2() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		selectionSort(a);
	}
}
