package me.dengfengdecao.stack_queue;

import org.junit.Test;

public class MyStackTest {

	void print(String tag, String value) {
		System.out.print(tag + ":" + value + "\t");
	}
	
	// 用例1：往空栈添加、删除元素
	@Test
	public void test1() throws Exception {
		// MyStack<Character> stack = new MyStack<Character>();
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Integer c = stack.pop();
		print("test1", String.valueOf(c));
	}
	
	// 用例2：往非空队列添加、删除元素
	@Test
	public void test2() throws Exception {
		MyStack<Character> stack = new MyStack<Character>();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		char c1 = stack.pop();
		char c2 = stack.pop();
		stack.push('d');
		print("test2", "c1=" + String.valueOf(c1));	// 预期结果c
		print("test2", "c2=" + String.valueOf(c2)); // 预期结果b
	}
	
	// 用例3：连续删除元素，直至栈为空
	@Test
	public void test3() throws Exception {
		MyStack<Character> stack = new MyStack<Character>();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		char c1 = stack.pop();
		char c2 = stack.pop();
		char c3 = stack.pop();
		print("test2", "c1=" + String.valueOf(c1));	// 预期结果c
		print("test2", "c2=" + String.valueOf(c2)); // 预期结果b
		print("test2", "c3=" + String.valueOf(c3)); // 预期结果a

		if (null == stack.pop()) return;
	}
}
