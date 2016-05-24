package me.dengfengdecao.other.sort;

import org.junit.Test;

/**
 * https://zh.wikipedia.org/wiki/希尔排序
 * @author linyu
 * @see 
 * http://blog.csdn.net/qy1387/article/details/7752973
 * http://blog.csdn.net/hnzhangshilong/article/details/7037684
 * http://blog.csdn.net/zzp_403184692/article/details/8014115
 */
public class ShellSort {

	/*
	 * 希尔排序:4,3,5,1,6,2,7,0,9,8
	 * 第一遍步长=4,{4,3,5,1}, {6,2,7,0} {9,8}, 4和6,3和2,5和7, 1和0比较
	 * 第二遍步长=1,直接插入排序
	 */
	void shellSort(int a[]) {
		int gap = 0, j;	// 步长
		int tmp;	// 缓存当前元素
		while (gap < a.length/3) {
			gap = gap * 3 + 1;
		}
		
		while (gap > 0) {
			for (int i = gap; i < a.length; i++) {	
				tmp = a[i];				
				for (j = i-gap; j >= 0 && a[j] > tmp; j-=gap) {
					a[j+gap] = a[j];	// 以步长为gap进行插入排序					
				}
				a[j+gap] = tmp;
				
				print(a);
			}
			
			gap /= 3;
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
		shellSort(a);
	}
	
	// 用例2：有重复数据
	@Test
	public void test2() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		shellSort(a);
	}
}
