package me.dengfengdecao.stack_queue;

import java.util.Stack;

/**
 * 两个栈实现一个队列功能
 * @author linyu
 * @param <T>
 *
 */
public class MyQueue<T> {

	private Stack<T> stack1 = new Stack<T>();	// 栈1用作队尾
	private Stack<T> stack2 = new Stack<T>();	// 栈2用作队头
	
	// 在队列末尾添加一个结点
	void appendTail(T node) {
    	stack1.push(node);    	
    };

    // 删除队列的头结点
    T deleteHead() {
    	// 若栈2为空,则循环将栈1所有元素出栈并推入栈2
    	// 此时，栈2元素顺序和栈1相反
    	if (stack2.size() <= 0) {
    		while (stack1.size() > 0) {
    			T n = stack1.pop();
    			stack2.push(n);
    		}
    	}
    	
    	// 若栈2元素为空则队列为空
    	if (stack2.size() == 0) {
    		throw new RuntimeException("queue is empty!");
    	}
    	
    	// 栈2（队头）不为空直接删除头结点
    	return stack2.pop();
    };
	
}
