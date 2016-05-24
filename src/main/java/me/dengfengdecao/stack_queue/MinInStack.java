package me.dengfengdecao.stack_queue;

import java.util.Stack;

import org.junit.Test;

/**
 * 包含min函数的栈,在该数据结构中能得到最小元素,push,pop,min操作的时间复杂度都是O(1):
 * 定义一个栈存放所有元素,一个辅助栈存放最小元素,每次入栈前都将小的元素入栈到辅助栈,
 * 每次出栈,则两个栈的栈顶元素都出栈.
 * @author linyu
 *
 */
public class MinInStack {
	
	private Stack<Integer> data = new Stack<Integer>();	// 数据栈，存放栈的所有元素
	private Stack<Integer> min = new Stack<Integer>();	 // 辅助栈，存放栈的最小元素
	
	void push (int value) {
		data.push(value);	// 把新元素添加到辅助栈
		
		// 当新元素比之前的最小元素小时，把新元素插入辅助栈里；
	    // 否则把之前的最小元素重复插入辅助栈里
		if (min.size() == 0 || value < (Integer)min.peek()) {
			min.push(value);
		} else {
			min.push(min.peek());
		}
	}

	void pop () {
		if (!data.empty())
			data.pop();
		
		if (!min.empty())
			min.pop();
	}
	
	int min () {
		int m = -1;
		if (!min.empty())
			m = min.peek();
		
		return m;
	}
	
	@Test
	public void test() throws Exception {
		MinInStack stack = new MinInStack();
		stack.push(3);
		System.out.println("压入3min:" + stack.min());
		stack.push(4);
		System.out.println("压入4min:" + stack.min());
		stack.push(2);
		System.out.println("压入2min:" + stack.min());
		stack.push(1);
		System.out.println("压入1min:" + stack.min());
		stack.pop();
		System.out.println("出栈min:" + stack.min());
		stack.pop();
		System.out.println("出栈min:" + stack.min());
		stack.push(0);
		System.out.println("压入0min:" + stack.min());
	}
}
