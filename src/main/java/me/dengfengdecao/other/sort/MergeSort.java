package me.dengfengdecao.other.sort;

import org.junit.Test;

/**
 * 归并排序:
 * 1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
   2、设定两个指针，最初位置分别为两个已经排序序列的起始位置
   3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
   4、重复步骤3直到某一指针达到序列尾
   5、将另一序列剩下的所有元素直接复制到合并序列尾
 * 
 * @author linyu
 * @see http://blog.csdn.net/morewindows/article/details/6678165
 */
public class MergeSort {
	
	void mergeSort(int a[], int left, int right, int tmpArr[]) {
		if (left < right) {
			int mid = (left + right)/2;
			mergeSort(a, left, mid, tmpArr);
			mergeSort(a, mid+1, right, tmpArr);
			merge(a, left, mid, right, tmpArr);
			//merge1(a, left, mid, right, tmpArr);
		}
	}

	// 合并
	private void merge(int[] a, int left, int mid, int right, int[] tmp) {				
		int l = left, m = mid + 1;		 
        int tmpIdx = left;	 // 记录临时数组的索引     
        int k = left; // 缓存左数组第一个元素的索引  
		while (l <= mid && m <= right) {
			// 将小的元素放到临时数组
			tmp[tmpIdx++] = a[l] < a[m] ? a[l++] : a[m++];				
		}			
		
		// 由于退出循环后，两部分数组中可能有一个数组元素还未处理完，所以需要额外的处理，当然不可     
        // 能两部分数组都有未处理完的元素，所以下面两个循环最多只有一个会执行，并且都是大于已放入     
        // 临时数组中的元素  
		while (l <= mid)
			tmp[tmpIdx++] = a[l++];
		
		while (m <= right) 
			tmp[tmpIdx++] = a[m++];
			
		// 最后把临时数组拷贝到源数组相同的位置
		while (k <= right)
			a[k] = tmp[k++];
		
		print(a);
		
	}
	
	void merge1(int[] arr, int left, int center, int right, int[] tmpArr) {
		int l = left, mid = center + 1; // 两个指针分别指向左右分区的首元素						
		int tmpIdx = left; // tmpIdx记录临时数组的索引
		int tmp = left;	// 缓存临时数组第一个元素索引
		while (l <= center && mid <= right) {
			// 从两个数组中取出最小的放入临时数组
			tmpArr[tmpIdx++] = arr[l] <= arr[mid] ? arr[l++] : arr[mid++];			
		}

		// 由于退出循环后，两部分数组中可能有一个数组元素还未处理完，所以需要额外的处理，当然不可     
        // 能两部分数组都有未处理完的元素，所以下面两个循环最多只有一个会执行，并且都是大于已放入     
        // 临时数组中的元素 
		while (l <= center) {
			tmpArr[tmpIdx++] = arr[l++];
		}

		while (mid <= right) {
			tmpArr[tmpIdx++] = arr[mid++];
		}

		// 将临时数组中的内容复制回原数组
		while (tmp <= right) {
			arr[tmp] = tmpArr[tmp++];
		}

		print(arr);
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
		int tmp[] = new int[a.length];
		mergeSort(a, 0, a.length-1, tmp);
	}
	
	// 用例2：有重复数据
	@Test
	public void test2() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		int tmp[] = new int[a.length];
		mergeSort(a, 0, a.length-1, tmp);
	}
	

}
