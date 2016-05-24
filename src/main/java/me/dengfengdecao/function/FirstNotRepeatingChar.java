package me.dengfengdecao.function;

import java.util.HashMap;

import org.junit.Test;

/**
 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
 * @author linyu
 *
 */
public class FirstNotRepeatingChar {
	
	char firstNotRepeatingChar(String str) {
		if (str == null) return '\0';
		
		// key：存放字符	value：存放字符出现的次数
		HashMap<Character, Integer> map = new HashMap<>();	
		char result = 0;
		
		// 遍历字符串,每遍历一个字符就在哈希表的对应项的值加1
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int val = 0;
			if (map.get(c) == null) {				
				map.put(c, 1);							
			} else {
				val = map.get(c);
				map.put(c, val+1);
			}
				
		}
		
		// 第二次遍历，找出第一个只出现一次的字符 
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int val = map.get(c);			
			if (val == 1) {
				result = c;
				return result;
			}
		}
		
		return result;
		
	}

	// 常规输入测试，存在只出现一次的字符
	@Test
	public void test1() throws Exception {
		char rel = firstNotRepeatingChar("google");
		System.out.println("test1 result:" + rel);
	}
	
	// 常规输入测试，不存在只出现一次的字符
	@Test
	public void test2() throws Exception {
		char rel = firstNotRepeatingChar("aabccdbd");
		System.out.println("test2 result:" + rel);
	}
	
	// 常规输入测试，所有字符都只出现一次
	@Test
	public void test3() throws Exception {
		char rel = firstNotRepeatingChar("abcdefg");
		System.out.println("test3 result:" + rel);
	}
	
	// 鲁棒性测试，输入NULL
	@Test
	public void test4() throws Exception {
		char rel = firstNotRepeatingChar(null);
		System.out.println("test4 result:" + rel);
	}
}
