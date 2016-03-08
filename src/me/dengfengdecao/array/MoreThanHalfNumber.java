package me.dengfengdecao.array;

import org.junit.Test;

/**
 * 找出数组中数字出现次数超过数组长度一半的数字:
 * 该数字出现的次数超过其它数字出现的次数的和.
 * @author linyu
 *
 */
public class MoreThanHalfNumber {

	/**
	 * 定义两个局部变量,一个保存数字,一个保存数字出现的次数,若下一数字和当前数字相同则次数加1,
	 * 否则次数减1.若次数为0,则遍历下一数字并设置次数为1.
	 * 由于要找的数字出现的次数超过其它数字出现的次数的和,所以最后一次将次数置1的数字就是要找的数字.
	 * @param number
	 * @param length
	 * @return
	 */
	int moreThanHalfNum(int[] number, int length) {
		if (number == null || number.length < 1) return -1;
		
		int resultNum = number[0];
		int time = 1;
		for (int i = 1; i < number.length; i++) {
			if (time == 0) {
				resultNum = number[i];
				time = 1;
			} else if (resultNum == number[i]) {
				time++;
			} else {
				time--;
			}
		}
		
		if (!checkMoreThanHalf(number, length, resultNum))
			return -1;
		
		return resultNum;
	}

	private boolean checkMoreThanHalf(int[] number, int length, int resultNum) {
		int times = 0;
	    for(int i = 0; i < length; ++i) {
	        if(number[i] == resultNum)
	            times++;
	    }
	    
	    if (times * 2 > number.length)
	    	return true;
	    
		return false;
	}
	
	// 存在出现次数超过数组长度一半的数字
	@Test
	public void test1() throws Exception {
		int num[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		int r = moreThanHalfNum(num, num.length);
		System.out.println("test1 r:" + r);
	}
	
	// 不存在出现次数超过数组长度一半的数字
	@Test
	public void test2() throws Exception {
		int num[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
		int r = moreThanHalfNum(num, num.length);
		System.out.println("test2 r:" + r);
	}
	
	// 出现次数超过数组长度一半的数字都出现在数组的前半部分
	@Test
	public void test3() throws Exception {
		int num[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
		int r = moreThanHalfNum(num, num.length);
		System.out.println("test3 r:" + r);
	}
	
	// 出现次数超过数组长度一半的数字都出现在数组的后半部分
	@Test
	public void test4() throws Exception {
		int num[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
		int r = moreThanHalfNum(num, num.length);
		System.out.println("test4 r:" + r);
	}
	
	// 数组只有1个数子
	@Test
	public void test5() throws Exception {
		int num[] = {1};
		int r = moreThanHalfNum(num, num.length);
		System.out.println("test5 r:" + r);
	}
	
	// 输入空指针
	@Test
	public void test6() throws Exception {
		int num[] = {};
		int r = moreThanHalfNum(num, 0);
		System.out.println("test6 r:" + r);
	}
}
