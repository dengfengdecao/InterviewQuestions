package me.dengfengdecao.other.search;

import org.junit.Test;

/**
 * 二分查找原理/思路：
 * 也称折半查找，是一种在有序数组中查找某一特定元素的搜索算法。
 * 搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
 * 如果在某一步骤数组为空，则代表找不到。
 * 这种搜索算法每一次比较都使搜索范围缩小一半。
 * 
 * @author linyu
 * @see https://zh.wikipedia.org/wiki/%E6%8A%98%E5%8D%8A%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95
 */
public class BinarySearch {

	// 迭代
	boolean binarySearch(int a[], int key) {
		if (a == null) return false;
		int lowIdx = 0;
		int hightIdx = a.length - 1;
		int midIdx;
		
		while (lowIdx <= hightIdx) {
			midIdx = lowIdx + ((hightIdx - lowIdx) >> 1); //直接平均可能會溢位，所以用此算法
			if (key > a[midIdx])	// key在数组右边
				lowIdx = midIdx + 1;
			else if (key < a[midIdx])	// key在数组左边
				hightIdx = midIdx - 1;
			else 	// 找到
				return true;							
		}
		
		return false;	// 未找到
	}
	
	// 递归
	boolean recursionlyBinarySearch(int a[], int lowIdx, int hightIdx, int key) {
		if (a == null) return false;
		
		int midIdx;
		if (lowIdx <= hightIdx) {
			midIdx = lowIdx + ((hightIdx - lowIdx) >> 1);
			if (key > a[midIdx]) {
				return recursionlyBinarySearch(a, midIdx+1, hightIdx, key);
			} else if (key < a[midIdx]) {
				return recursionlyBinarySearch(a, lowIdx, midIdx-1, key);
			} else {
				return true;
			}
						
		}
		
		return false;
	}
	
	@Test
	public void test1() throws Exception {
		int a[] = {1, 4, 5, 6, 8, 11, 17};
		boolean b1 = binarySearch(a, 6);
		boolean b2 = binarySearch(a, 1);
		boolean b3 = binarySearch(a, 17);
		boolean b4 = binarySearch(a, 4);
		boolean b5 = binarySearch(a, 8);
		boolean b6 = binarySearch(null, 6);
		
		System.out.println("b1:" + b1);
		System.out.println("b2:" + b2);
		System.out.println("b3:" + b3);
		System.out.println("b4:" + b4);
		System.out.println("b5:" + b5);
		System.out.println("b6:" + b6);
	}
	
	@Test
	public void test2() throws Exception {
		int a[] = {1, 4, 5, 6, 8, 11, 17};
		boolean b1 = recursionlyBinarySearch(a, 0, a.length-1, 6);
		boolean b2 = recursionlyBinarySearch(a, 0, a.length-1, 1);
		boolean b3 = recursionlyBinarySearch(a, 0, a.length-1, 17);
		boolean b4 = recursionlyBinarySearch(a, 0, a.length-1, 4);
		boolean b5 = recursionlyBinarySearch(a, 0, a.length-1, 8);
		boolean b6 = recursionlyBinarySearch(null, 0, a.length, 6);
		
		System.out.println("b1:" + b1);
		System.out.println("b2:" + b2);
		System.out.println("b3:" + b3);
		System.out.println("b4:" + b4);
		System.out.println("b5:" + b5);
		System.out.println("b6:" + b6);
	}
}
