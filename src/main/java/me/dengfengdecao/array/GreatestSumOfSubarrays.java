package me.dengfengdecao.array;

import org.junit.Test;

/**
 * 找出数组(有正数和负数)的最大子序列和
 * @author linyu
 *
 */
public class GreatestSumOfSubarrays {

	boolean invalid;
	int findGreatestSumOfSubArray(int a[]) {
		if (a == null || a.length <= 0){
			invalid = true;
			return -1;
		}
		
		invalid = false;
		int curNum = 0; 
		int greatestSum = 0x80000000;	// -2147483648
		// 依次将当前数字累加,若当前数字为负数或0(负数累加越来越小),计算下一数字,否则累加,
		// 若当前累加的和大于最大子序列和则更新最大子序列和.
		for (int i = 0; i < a.length; i++) {
			if (curNum <= 0) {
				curNum = a[i];		
			} else {
				curNum += a[i];
			}
			
			if (curNum > greatestSum)
				greatestSum = curNum;
		}
		
		return greatestSum;
	}
	
	// 数字有正有负
	@Test
	public void test1() throws Exception {
		int data[] = {1, -2, 3, 10, -4, 7, 2, -5};
		int greatestSum = findGreatestSumOfSubArray(data);
		System.out.println("test1 invalid:" + invalid + "greatestSum:" + greatestSum);
	}

	// 所有数字都是负数
	@Test
	public void test2() throws Exception {
		int data[] = {-2, -8, -1, -5, -9};
		int greatestSum = findGreatestSumOfSubArray(data);
		System.out.println("test2 invalid:" + invalid + "greatestSum:" + greatestSum);
	}
	
	// 所有数字都是正数
	@Test
	public void test3() throws Exception {
		int data[] = {2, 8, 1, 5, 9};
		int greatestSum = findGreatestSumOfSubArray(data);
		System.out.println("test3 invalid:" + invalid + "greatestSum:" + greatestSum);
	}
	
	// 无效输入
	@Test
	public void test4() throws Exception {
		int data[] = {};
		int greatestSum = findGreatestSumOfSubArray(data);
		System.out.println("test4 invalid:" + invalid + "greatestSum:" + greatestSum);
	}
}
