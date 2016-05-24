package me.dengfengdecao.stack_queue;

import org.junit.Test;

public class MyQueueTest {

	// 用例1：往空队列添加、删除元素
	@Test
	public void test1() {
		MyQueue<Character> queue = new MyQueue<Character>();
		queue.appendTail('a');
		queue.appendTail('b');
		queue.appendTail('c');
		
		char c1 = queue.deleteHead();
		print("test1", String.valueOf(c1));	
	}

	// 用例2：往非空队列添加、删除元素
	@Test
	public void test2() {
		MyQueue<Character> queue = new MyQueue<Character>();
		queue.appendTail('a');
		queue.appendTail('b');
		queue.appendTail('c');
		
		char c1 = queue.deleteHead();
		char c2 = queue.deleteHead();
		print("test2", String.valueOf(c1));	
		print("test2", String.valueOf(c2));
		
		queue.appendTail('d');
	}
	
	// 用例3：连续删除元素，直至队列为空
	@Test
	public void test3() {
		MyQueue<Character> queue = new MyQueue<Character>();
		queue.appendTail('a');
		queue.appendTail('b');
		queue.appendTail('c');
		
		char c1 = queue.deleteHead();
		char c2 = queue.deleteHead();
		char c3 = queue.deleteHead();
		print("test3", String.valueOf(c1));	
		print("test3", String.valueOf(c2));
		print("test3", String.valueOf(c3));
		
		queue.deleteHead();
	}
	
	void print(String tag, String value) {
		System.out.print(tag + ":" + value + "\t");
	}
}
