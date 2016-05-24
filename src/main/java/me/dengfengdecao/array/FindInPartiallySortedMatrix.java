package me.dengfengdecao.array;

import org.junit.Test;

/**
 * 二维数组matrix中，每一行都从左到右递增排序，每一列都从上到下递增排序
 *  1   2   8   9
 *  2   4   9   12
 *  4   7   10  13
 *  6   8   11  15
 * @author linyu
 *
 */
public class FindInPartiallySortedMatrix {

	/**
	 * 从二维数组右上角开始查找，如果找到返回true，结束查找，
	 * 如果右上角的数组大于要查找的数字则，剔除该列，否则剔除该行。
	 * @param matrix 
	 * @param rows 
	 * @param columns
	 * @param number 要查找的数字
	 * @return
	 */
	public boolean find(int[][] matrix, int rows, int columns, int number) {
		boolean found = false;
		
		int row = 0; // 初始化当前行
		int column = columns - 1; // 初始化最后一列
		if (matrix != null && rows > 0  && column > 0) {

			while (row < rows && column >= 0) {
				if (matrix[row][column] == number) {
					found = true;
					break;					
				} else if (matrix[row][column] > number) {
					column -- ;
				} else {
				    row ++;
				}
				
			}
		}
		
		return found;
	}
	
	// 用例1：
	// 正常数据,number=7
	@Test
	public void test1() {
		int m[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
		boolean b = find(m, 4, 4, 7);
		System.out.println(b);
	}
	
	// 用例2：
		// 最小数,number=1
		@Test
		public void test2() {
			int m[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
			boolean b = find(m, 4, 4, 1);
			System.out.println(b);
		}
	// 用例3：
	// 比最小数更小,number=0
	@Test
	public void test3() {
		int m[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
		boolean b = find(m, 4, 4, 0);
		System.out.println(b);
	}
	
	// 用例4：
		// 最大数,number=15
		@Test
		public void test4() {
			int m[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
			boolean b = find(m, 4, 4, 15);
			System.out.println(b);
		}
		
		// 用例5：
		// 比最大数还大,number=16
		@Test
		public void test5() {
			int m[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
			boolean b = find(m, 4, 4, 16);
			System.out.println(b);
		}
		
		// 用例6：
		// 要查找的数字不在数组中,number=5
		@Test
		public void test6() {
			int m[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
			boolean b = find(m, 4, 4, 5);
			System.out.println(b);
		}
}
