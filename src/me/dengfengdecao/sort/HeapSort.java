package me.dengfengdecao.sort;

import org.junit.Test;

/**
* https://zh.wikipedia.org/wiki/%E5%A0%86%E6%8E%92%E5%BA%8F
* @author linyu
* @see 
* http://blog.csdn.net/qy1387/article/details/7752973
* http://blog.csdn.net/hnzhangshilong/article/details/7037684
* http://blog.csdn.net/zzp_403184692/article/details/8014115
* 
*/
public class HeapSort {
	
	void buildMaxHeapify(int a[]) {
		int startIndex = getParentIndex(a.length);
		//从尾端开始创建最大堆
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(a, a.length, i);
		}		
	}
	

	/**
	 * 创建最大堆
	 * @param a 待构建序列
	 * @param heapSize 需要创建最大堆的大小
	 * @param idx 最大堆的索引
	 */
	private void maxHeapify(int[] a, int heapSize, int idx) {
		// 当前点与左右子节点比较
		int left = getChildLeftIndex(idx);
		int right = getChildRightIndex(idx);
		
		int largest = idx;		
		if (left < heapSize && a[left] > a[largest]) {
			largest = left;
		}
		
		if (right < heapSize && a[right] > a[largest]) {
			largest = right;
		}
		
		// 若当前节点的左右子节点较大,则交换,并递归堆化
		if (largest != idx) {
			int tmp = a[idx];
			a[idx] = a[largest];
			a[largest] = tmp;
			maxHeapify(a, heapSize, largest);
		}
	}
	
	// 堆排序,a已堆化,遍历a,每次将最大堆放到末尾,最后是递增序列
	void heapSort(int a[]) {
		for (int i = a.length-1; i > 0; i--) {
			int tmp = a[0];	// a[0]为最大堆
			a[0] = a[i];	// a[i]]为从后向前的当前元素
			a[i] = tmp;
			
			print(a);
			
			maxHeapify(a, i, 0);	// 依次找到最大堆
		}
	}

	/**
	 * 父节点位置	
	 * @param currentIndex
	 * @return
	 */
	private int getParentIndex(int currentIndex) {
		// 子节点i的父节点索引值p:p=(i-1)/2	
		return (currentIndex-1) >> 1;
	}
	
	/**
	 * 左子节点position注意括号，加法优先级更高
	 * @param current
	 * @return
	 */
	private static int getChildLeftIndex(int current){
		// 当前节点c的左节点l:l=c*2+1
		return (current << 1) + 1;
	}
	
	/**
	 * 右子节点position
	 * @param current
	 * @return
	 */
	private static int getChildRightIndex(int current){
		// 当前节点c的右节点r:r=c*2+2
		return (current << 1) + 2;
	}

	public void print(int[] arr) {  
		for (int i = 0; i < arr.length; i++) {  
			System.out.print(arr[i] + "\t");  
		}  
		System.out.println();  
	}  

	// 用例1：正常数据
	@Test
	public void test1() throws Exception {
		int a[] = {4,3,5,1,6,2,7,0,9,8};
		buildMaxHeapify(a);
		heapSort(a);		
	}
	
	// 用例2：有重复数据
	@Test
	public void test2() {
		int a[] = {4,3,5,1,6,2,7,0,9,8,4};
		buildMaxHeapify(a);
		heapSort(a);	
	}
	
}
