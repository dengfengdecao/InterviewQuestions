package me.dengfengdecao.sort;

import org.junit.Test;

/**
 * 快速排序:
 * http://blog.csdn.net/morewindows/article/details/6684558
 * @author linyu
 * @see https://zh.wikipedia.org/wiki/快速排序
 * http://blog.csdn.net/hnzhangshilong/article/details/7037684
 * http://blog.csdn.net/qy1387/article/details/7752973
 * http://blog.csdn.net/zzp_403184692/article/details/8014115
 */
public class QuickSort {
	
	void recursionQuickSort(int a[], int left, int right) {
		if (right > left) {
			int i = left, j = right;
			int pivotValue = a[left]; // 以分区的首元素作为枢轴
			while (j > i) {
				while (j > i && a[j] >= pivotValue)
					j--;	// 向左移动找比枢轴小的元素
				
				if (j > i)
					a[i++] = a[j];	// 将找到的较小元素换到当前i位置,并将i向右移动
				
				while (j > i && a[i] <= pivotValue)
					i++;	// 向右移动找比枢轴大的元素
				
				if (j > i)
					a[j--] = a[i];	// 将找到的较大元素换到当前j位置,并将j向左移动				
			}
			
			a[i] = pivotValue;	// 当i == j,即分区完一遍时,将枢轴元素放到当前位置,也可以是a[j] = pivotValue
			
			print(a);
			
			recursionQuickSort(a, left, i-1);
			recursionQuickSort(a, j+1, right);
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
		recursionQuickSort(a, 0, a.length-1);
	}
	
	// 用例1：有重复数据
	@Test
	public void test2() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		recursionQuickSort(a, 0, a.length-1);
	}

}
