package me.dengfengdecao.sort;

import org.junit.Test;

/**
 * 冒泡排序:
 * https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F
 * @author linyu
 * @see http://blog.csdn.net/zzp_403184692/article/details/8014115
 * http://blog.csdn.net/qy1387/article/details/7752973
 * http://blog.csdn.net/hnzhangshilong/article/details/7037684
 */
public class BubbleSort {

	/**
	 * 算法:
	 * 1,比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	   2,对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
	   3,这步做完后，最后的元素会是最大的数。针对所有的元素重复以上的步骤，除了最后一个。
	   4,持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 * @param a 待排序序列
	 */
	void bubbleSort(int a[]) {
		int tmp;
		for (int i = 0; i < a.length-1; i++) {	// 循环n-1遍
			for (int j = 0; j < a.length-1-i; j++) {	// 遍历完一次最大值沉底,相应的比较次数减去当前已遍历的次数,小的值冒泡上来.
				if (a[j] > a[j+1]) {	// 比较相邻元素并交换
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					
					print(a);
				}	
				
			}
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
		bubbleSort(a);
	}
	
	// 用例1：有重复数据
	@Test
	public void test2() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		bubbleSort(a);
	}

}
