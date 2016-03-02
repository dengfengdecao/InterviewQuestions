package me.dengfengdecao.other.sort;

import java.util.Stack;

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
	
	// 递归快排
	void recursionQuickSort(int a[], int left, int right) {
		int pivotValue, pivotIdx;
		if (right > left) {			
			pivotValue = a[left]; // 以分区的首元素作为枢轴
			pivotIdx = partition(a, left, right, pivotValue);
			
			recursionQuickSort(a, left, pivotIdx-1);
			recursionQuickSort(a, pivotIdx+1, right);
		}
	}
		
	// 非递归快排
	// http://www.myexception.cn/cpp/1887480.html
	void quickSort(int a[], int left, int right) {
		Stack<Integer> stack = new Stack<Integer>();	// 存索引
		int l = left, r = right;
		int pivotValue, pivotIdx;
		if (r > l) {
			pivotValue = a[l]; // 以分区的首元素作为枢轴
			pivotIdx = partition(a, l, r, pivotValue);
			
			if (pivotIdx-1 > l) {	// 左区先入栈
				stack.push(pivotIdx - 1);
				stack.push(l);
			}
			if (r > pivotIdx+1) {	// 右区后入栈
				stack.push(r);				
				stack.push(pivotIdx+1);
			}
				
			// 当栈存储的索引不为空时,循环处理
			while (!stack.empty()) {
				l = stack.pop();
				r = stack.pop();
				
				pivotValue = a[l]; // 以分区的首元素作为枢轴
				pivotIdx = partition(a, l, r, pivotValue);
				
				if (pivotIdx-1 > l) {	// 左区先入栈
					stack.push(pivotIdx - 1);
					stack.push(l);
				}
				if (r > pivotIdx+1) {	// 右区后入栈
					stack.push(r);				
					stack.push(pivotIdx+1);
				}
				
				print(a);
			}
		}
	}
	
	/**
	 * 分区操作,分成左右两区
	 * @param a
	 * @param left 左区
	 * @param right 右区
	 * @param pivotValue 枢轴值
	 * @return 返回新的枢轴索引
	 */
	int partition(int[] a, int left, int right, int pivotValue) {
		int i = left, j = right;
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
		
		return i;
	}

	
	public void print(int[] arr) {  
		for (int i = 0; i < arr.length; i++) {  
			System.out.print(arr[i] + "\t");  
		}  
		System.out.println();  
	}  
	
	// 用例1：递归正常数据
	@Test
	public void test1() {
		int a[] = {4,3,5,1,6,2,7,0,9,8};
		recursionQuickSort(a, 0, a.length-1);
	}
	
	// 用例2：递归有重复数据
	@Test
	public void test2() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		recursionQuickSort(a, 0, a.length-1);
	}
	
	// 用例3：非递归正常数据
	@Test
	public void test3() {
		int a[] = {4,3,5,1,6,2,7,0,9,8};
		quickSort(a, 0, a.length-1);
	}
	
	// 用例4：非递归有重复数据
	@Test
	public void test4() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		quickSort(a, 0, a.length-1);
	}

}
