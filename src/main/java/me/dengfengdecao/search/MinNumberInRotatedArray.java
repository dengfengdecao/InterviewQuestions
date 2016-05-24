package me.dengfengdecao.search;

import org.junit.Test;

/**
 * 二分查找的应用
 * 找出旋转数组的最小数字
 * 例:1, 2, 3, 4, 5 旋转后3, 4, 5, 1, 2
 * 最小数字为1
 * 
 * @author linyu
 *
 */
public class MinNumberInRotatedArray {

	int min(int arr[]) {
		if (arr == null) {
			throw new RuntimeException("无效数据");
		}
		
		int idx1 = 0;	// 指向数组首个元素
		int idx2 = arr.length - 1; // 指向数组最后一个元素
		int midIdx = idx1;	// 指向数组的中间元素
	
		// 首元素大于或等于末尾元素,例:3, 4, 5, 1, 2
		while (arr[idx1] >= arr[idx2]) {	
			// 如果idx1和idx2指向相邻的两个数，
	        // 则idx1指向第一个递增子数组的最后一个数字，
	        // idx2指向第二个子数组的第一个数字，也就是数组中的最小数字
			if (idx2 - idx1 == 1) {
				midIdx = idx2;
				break;
			}
			
			midIdx = (idx1 + idx2) / 2;
			// 如果首尾和中间元素相同,则无法判断最小数字在左边还是右边的递增子序列中
			// 此时,只能用顺序查找算法实现
			if (arr[idx1] == arr[midIdx] && arr[idx1] == arr[idx2]) {
				return midInOrder(arr);
			}
			
			// 若首元素小于或等于中间元素,则最小元素在右边子序列
			// 将第一个索引指向右子序列的首元素
			if (arr[idx1] <= arr[midIdx]) {	
				idx1 = midIdx; 
			} else if (arr[idx2] >= arr[midIdx]) {
				// 若末尾元素大于或等于中间元素,则最小元素在左边子序列
				// 将末尾索引指向左子序列的末尾元素
				idx2 = midIdx;
			}					
		}
		
		// 若首元素小于最后一个元素,即数组首元素是最小数字,直接返回
		return arr[midIdx];
	}

	// 顺序查找
	private int midInOrder(int[] arr) {
		int minNumberIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr[minNumberIdx])
				minNumberIdx = i;
		}
		
		return arr[minNumberIdx];
	}
	
	public void print(String tag, int a) {  
		System.out.println(tag + ":" + a);  
	}  
	
	
	@Test
	public void test1() throws Exception {
		 // 典型输入，单调升序的数组的一个旋转
	    int array1[] = {3, 4, 5, 1, 2};
	    print("array1", min(array1));	    	   	   
	}

	@Test
	public void test7() {
		// 输入NULL
	    print("array null", min(null));
	}

	@Test
	public void test6() {
		// 数组中只有一个数字
	    int array6[] = {2};
	    print("array6", min(array6));
	}

	@Test
	public void test5() {
		// 单调升序数组，旋转0个元素，也就是单调升序数组本身
	    int array5[] = {1, 2, 3, 4, 5};
	    print("array5", min(array5));
	}

	@Test
	public void test4() {
		// 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
	    int array4[] = {1, 0, 1, 1, 1};
	    print("array4", min(array4));
	}

	@Test
	public void test3() {
		// 有重复数字，重复的数字是最后一个数字
	    int array3[] = {3, 4, 5, 1, 2, 2};
	    print("array3", min(array3));
	}

	@Test
	public void test2() {
		// 有重复数字，并且重复的数字刚好是最小的数字
	    int array2[] = {3, 4, 5, 1, 1, 2};
	    print("array2", min(array2));
	}
}
