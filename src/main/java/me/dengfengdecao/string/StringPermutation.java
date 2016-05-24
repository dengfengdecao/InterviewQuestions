package me.dengfengdecao.string;

import org.junit.Test;

/**
 * 输入一个字符串,打印该字符串中字符的所有排列:
 * ㈠求出所有可能出现在第一个位置的字符,即把第一个字符和后面所有的字符交换;
 * ㈡再把后面的所有字符分成两部分,重复㈠
 * @author linyu
 *
 */
public class StringPermutation {

	/**
	 * 全排列
	 * 字符串排列,输入ab,输出ab, ba
	 * @param str 字符串
	 * @param begin 指向排列字符串的第一个字符
	 */
	void permutation(char[] str, int begin) {
		if (str == null || begin >= str.length) return;
			
		if (begin == str.length-1) {
			System.out.println(String.valueOf(str));
		} else {
			for (int i = begin; i < str.length; i++) {
				// 交换前缀,使之产生下一个前缀.				
				swap(str, begin, i);
				
				permutation(str, begin+1);
				
				// 将前缀换回来,继续做上一个的前缀排列.
				swap(str, begin, i);
			}
		}				
	}
	
	private void swap(char[] str, int begin, int i) {
		char tmp = str[i];
		str[i] = str[begin];
		str[begin] = tmp;
	}
	
	
	@Test
	public void test() throws Exception {
		char string1[] = {};
		permutation(string1, 0);    	 
	}
	
	@Test
	public void test2() throws Exception {
		char string2[] = {'a'};
	    permutation(string2, 0);
	}
	@Test
	public void test3() throws Exception {
		char string3[] = {'a','b'};
	    permutation(string3, 0);
	}
	@Test
	public void test4() throws Exception {
		char string4[] = {'a','b','c'};
	    permutation(string4, 0);
	}
}
