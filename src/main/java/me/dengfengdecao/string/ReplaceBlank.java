package me.dengfengdecao.string;

import org.junit.Test;

/**
 * 替换字符串中的空格为%20
 * @author linyu
 *
 */
public class ReplaceBlank {
	
	char[] replaceBlank(String str) {
		if (str == null) return null;
		// 遍历字符串
		int originalLength = 0;	// str字符串长度
		int numberOfBlank = 0; // 空格数量
		int i = 0;
		
		while ( originalLength <= str.length() && i < str.length() ) {
			originalLength ++;
			
			if (str.charAt(i) == ' ') {
				numberOfBlank ++;
			}
			
			i ++;
		}
		
		// newLength 为把空格替换成'%20'之后的长度
		int newLength = originalLength + numberOfBlank * 2;
		char[] c = new char[newLength];	// 将源数组拷贝到新数组c		
	
		int indexOfOriginal = originalLength - 1;	// 指向源字符数组末尾
		int indexOfNew = newLength - 1;	// 指向替换后字符数组末尾
		while (indexOfOriginal >= 0 && indexOfNew >= indexOfOriginal) {
			if (str.charAt(indexOfOriginal) == ' ') {	// 最后一个字符是空格，开始替换,indexOfNew向前移动3格
				c[indexOfNew--] = '0';
				c[indexOfNew--] = '2';
				c[indexOfNew--] = '%';
				
			} else {
				// 否则把源字符数组最后一位拷贝到新数组并且indexOfNew向前移动一格,
				// c[indexOfNew--] = str.charAt(indexOfOriginal);
				System.arraycopy(str.toCharArray(), indexOfOriginal, c, indexOfNew--, 1);
			}
			
			// indexOfOriginal向前移动一格
			indexOfOriginal -- ;
		}
				
		return c;
	}
	
	// 用例1：
	// 空格在中间
	@Test
	public void test1() {
		System.out.println("test1:");
		String s = "hello world";
		char[] str = replaceBlank(s);
		
		for (char c : str) {
			System.out.print(c + ",");
		}		
	}
	
	// 用例2：
	// 空格在左间
	@Test
	public void test2() {
		System.out.println("test2:");
		String s = " helloworld";
		char[] str = replaceBlank(s);
		
		for (char c : str) {
			System.out.print(c + ",");
		}		
	}

	// 用例3：
	// 空格在右间
	@Test
	public void test3() {
		System.out.println("test3:");
		String s = "helloworld ";
		char[] str = replaceBlank(s);
		
		for (char c : str) {
			System.out.print(c + ",");
		}		
	}
	
	// 用例4：
	// 两个空格在中间
	@Test
	public void test4() {
		System.out.println("test4:");
		String s = "hello  world";
		char[] str = replaceBlank(s);
		
		for (char c : str) {
			System.out.print(c + ",");
		}		
	}
}
