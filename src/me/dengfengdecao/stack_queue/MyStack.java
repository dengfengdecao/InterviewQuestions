package me.dengfengdecao.stack_queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * 队列:先进先出,只在队尾添加节点和在队头删除节点
 * 栈:先进后出,只在栈顶添加和删除节点
 * @author linyu
 *
 */
public class MyStack<T> {

	Queue<T> queue1 = new PriorityQueue<>(); 
	Queue<T> queue2 = new PriorityQueue<>(); 
	
	// 入栈,在队1添加节点
	void push (T node) {
		queue1.add(node);
	}
	
	/*
	 * 出栈,若队1有一个节点则直接出队,若大于1个节点,则将
	 * 队1所有节点从队头出队,并将其依次加入到队2队尾,并删除队1最后一个节点,
	 * 最后将队2所有节点依次返回队1.(两个队列节点排序相同)
	 */
	T pop () {
		T node = null;
		if (!queue1.isEmpty()) {
			int size1 = queue1.size();
			for (int i = 0; i < size1; i++) {
				if (queue1.size() == 1) {
					node = queue1.remove();
				} else {
					queue2.add(queue1.remove());					
				}
			}			
		}
		
		int size2 = queue2.size();
		for (int i = 0; i < size2; i++) {
			queue1.add(queue2.remove());
		}
		
		return node;
	}	
}


