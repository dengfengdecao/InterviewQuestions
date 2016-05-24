package me.dengfengdecao.array;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
 * 输入n个整数,找出其中最小的k个数
 * @author linyu
 *
 */
public class KLeastNumbers {

	/**
	 * 基于partition函数,比第k个数小的排在左边,大的排在右边,排好后就得出最小的k个数
	 * 就是左边的k个数.
	 * 该方法会调整输入数组的数字位置并且要一次性将输入数组装入内存不适用于大数据.
	 * @param input 要输入的数组
	 * @param n 数组长度
	 * @param k 第k个数
	 */
	int[] getLeastNumbers(int input[], int n, int k) {
		if (input == null || input.length <= 0 || n < k) return null;
		
		int output[] = new int[k];	// 存储最小的k个数字
		int start = 0;
		int end = n - 1;
		
		int pivotIdx = partition(input, start, end);
		
		while (pivotIdx != k - 1) {	// 当枢轴不指向第k个数字时
			// 枢轴比第k个数索引大则枢轴向左移一位再次分区
			// 否则枢轴向右移动一位
			if (pivotIdx > k - 1) {	
				pivotIdx = partition(input, start, pivotIdx-1);
			} else {
				pivotIdx = partition(input, pivotIdx+1, end);
			}
		}
		
		// 将第k个数左边的数字存到输出数组
		for (int i = 0; i < k; i++) {
			output[i] = input[i];
		}
		
		return output;
	}

	private int partition(int[] input, int start, int end) {
		// 分区操作
		int l = start;
		int r = end;
		
		int pivotValue = input[start];
		
		while (r > l) {
			// 先从数组的后往前判断
			while (r > l && input[r] >= pivotValue)
				r--;
			
			if (r > l)
				input[l++] = input[r];
			
			while (r > l && input[l] <= pivotValue)
				l++;
			
			if (r > l)
				input[r--] = input[l];	// 大的放到右边,然后右边的索引左移
			
		}
		
		input[l] = pivotValue;
		return l;
	}
	
	// ====================测试代码====================
	// k小于数组的长度
	@Test	
	public void test1() throws Exception {
		int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
		int output[] = getLeastNumbers(data, data.length, 4);
		if (output == null) return;
		for (int i : output) {
			System.out.print(i + "\t");
		}
	}
	
	// k等于数组的长度
	@Test	
	public void test11() throws Exception {
		int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
		int output[] = getLeastNumbers(data, data.length, 8);
		if (output == null) return;
		for (int i : output) {
			System.out.print(i + "\t");
		}
	}
	
	// k大于数组的长度
	@Test	
	public void test12() throws Exception {
		int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
		int output[] = getLeastNumbers(data, data.length, 9);
		if (output == null) return;
		for (int i : output) {
			System.out.print(i + "\t");
		}
	}

	// k等于1
	@Test	
	public void test3() throws Exception {
		int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
		int output[] = getLeastNumbers(data, data.length, 1);
		if (output == null) return;
		for (int i : output) {
			System.out.print(i + "\t");
		}
	}
	
	// k等于0
	@Test	
	public void test4() throws Exception {
		int data[] = {4, 5, 1, 6, 2, 7, 3, 8};
		int output[] = getLeastNumbers(data, data.length, 0);
		if (output == null) return;
		for (int i : output) {
			System.out.print(i + "\t");
		}
	}

	// 数组中有相同的数字
	@Test	
	public void test5() throws Exception {
		int data[] = {4, 5, 1, 6, 2, 7, 2, 8};
		int output[] = getLeastNumbers(data, data.length, 2);
		if (output == null) return;
		for (int i : output) {
			System.out.print(i + "\t");
		}
	}

	// 输入空指针
	@Test	
	public void test6() throws Exception {
		int data[] = null;
		int output[] = getLeastNumbers(data, 0, 2);
		if (output == null) return;
		for (int i : output) {
			System.out.print(i + "\t");
		}
	}
}
