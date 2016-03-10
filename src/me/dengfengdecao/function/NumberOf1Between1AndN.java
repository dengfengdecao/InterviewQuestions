package me.dengfengdecao.function;

import org.junit.Test;

public class NumberOf1Between1AndN {

	/**
	 * 求整数1到n中1出现的个数:
	 * 将整数模10判断是否等于1,是则计数器加1,然后整除10,判断各位是否为1 
	 * 本方法时间复杂度为O(nlogn)
	 * @param n
	 * @return
	 */
	int numberOf1Between1AndN(int n) {
		if (n <= 0) return -1;
		
		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			int num = i;
			while (num != 0) {
				if (num % 10 == 1) {
					count++;
				}
				
				num = num / 10;
			}			
		}
		
		return count;
	}
	
	@Test
	public void test() throws Exception {
		int count = numberOf1Between1AndN(12);
		System.out.println("count:" + count);
	}
}
