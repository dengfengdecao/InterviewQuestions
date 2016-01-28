package me.dengfengdecao.list;

import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * 输入链表的头节点，从尾到头打印出各节点的值
 * @author linyu
 *
 */
public class ListNode {
	

	<T> void printListReversingly(Node<T> headNode) {
		Stack<Node> nodes = new Stack<Node>();
		
		Node node = headNode;
		if (node != null) {
			nodes.push(node);	// 推入栈顶
			node = node.nextNode;	// 将头节点的下一个节点赋给当前节点
		}
		
		while (!nodes.isEmpty()) {
			node = nodes.peek();	// 将栈顶节点赋给当前节点并打印
			System.out.print(node.data + "\t");
			nodes.pop();	// 栈顶节点出栈
		}		
	}
	
	class Node<T> {
		private int data;
		private Node<T> headNode;
		private Node<T> nextNode;
	}
	@Test
	public void test1() {
		Node<Integer> node = null;
		for (int i=0; i<10; i++) {
			node = new Node<Integer>();
			if (i == 0) {
				node.headNode.data = i;
			} else {
				node.nextNode.data = i;
			}
		}
		
		printListReversingly(node.headNode);
		
	}
	
}
