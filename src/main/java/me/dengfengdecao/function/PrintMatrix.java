package me.dengfengdecao.function;

/**
 * 输入一个矩阵，按照从外向里以顺时针顺序依次打印出每一个数字，
 * 例如：如果输入如下矩阵： 
	1   2   3   4 
	5   6   7   8 
	9   10  11  12 
	13  14  15  16 
	则依次打印出数字1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10。
 * @author linyu
 *
 */
public class PrintMatrix {

	/**
	 * 这个循环结束的条件。对一个5×5的矩阵而言，最后一圈只有一个数字，对应的坐标为(2, 2)。
	 * 我们发现5 > 2 * 2。对一个6×6的矩阵而言，最后一圈有四个数字，对应的坐标仍然为(2, 2)。我们发现6 > 2 * 2依然成立。
	 * 于是我们可以得出，让循环继续的条件是columns > startX * 2 && rows > startY * 2。
	 * @param marix 矩阵
	 * @param row 行索引
	 * @param column 列索引
	 * @param start 一圈开始的左上角的坐标值(x、y)坐标是相同的，例如5X5,第一圈左上角(start,start)即为(0,0)...) 
	 */
	static void printMatrix(int[][] matrix, int row, int column, int start) {
		if (matrix == null || row < 1 || column < 1) return;
		
		int stopX = column - start - 1;	// 一圈最右列在坐标中的位置 
		int stopY = row - start - 1;	// 一圈最大行在坐标中的位置 
		if (row > start * 2 && column > start * 2) {
			// 打印此圈中的最上行
			for (int i = start; i <= stopX; i++) {
				print(matrix[start][i]);
			}
			
			// 打印此圈中的最右列
			if (start < stopX) {	// 如果此圈中不止有一列 
				for (int i = start+1; i <= stopY;  i++) {
					print(matrix[i][stopX]);
				}				
			}
			
			// 打印次圈中的最下行
			if (start < stopX && start < stopY) {
				for (int i = stopX-1; i >= start; i--) {
					print(matrix[stopY][i]);
				}
			}
			
			// 打印次圈中的最左列
			if (start < stopX && start < stopY-1) {
				for (int i = stopY-1; i >= start+1; i--) {
					print(matrix[i][start]);
				}
			}
			
			// 递归,下一圈循环  
			printMatrix(matrix, row, column, start+1);
		}
	}

	private static void print(int i) {
		System.out.print(i + ",");		
	}

	public static void main(String[] args) {
		int m[][] = {
				{1,   2,  3,   4}, 
				{5,   6,   7,   8}, 
				{9,   10, 11,  12}, 
				{13,  14,  15,  16} 	
		};
		
		printMatrix(m, 4, 4, 0);
	}
}
