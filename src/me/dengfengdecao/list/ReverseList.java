package me.dengfengdecao.list;

import org.junit.Test;

/**
 * 反转链表,返回反转后的头节点
 * 解法1:
 * ①定义三个指针分别指向当前节点的上一节点,当前节点,当前节点的下一节点.
 * ②首先将头节点赋给当前节点,则当前节点的上一节点初始化为空,③之后将当前节点的下一节点赋给当前节点,
 * ④当当前节点的下一节点为空时,到达链表末尾,尾节点即反转后链表的头节点.
 * 重复②③④
 * @author linyu
 *
 */
public class ReverseList {

	// 迭代
	Node reverseList(Node head) {
		if (head == null) return null;
		
		Node reverseHead = null;	// 反转之后链表的头节点
		Node prev = null;	// 当前节点的上一节点
		Node node = head;	// 当前节点
		while (node != null) {
			Node next = node.next;	// 缓存当前节点的下一节点
			if (node.next == null)
				reverseHead = node;	
			
			// 将当前节点的指针指向上一个节点,即指针反转		
			node.next = prev;	// 第一次遍历,当前节点(即头节点)的上一节点为空
			prev = node;	// 将当前节点赋给上一节点(即当前节点变为下一节点的上一节点)
			node = next;	// 将下一节点赋给当前节点(即指针指向下一节点)
		}
		
		return reverseHead; 
	}
	
	// 递归
	Node recursionlyReverseList(Node head) {
		if (head == null) return null;
		
		Node reverseHead = null;
		Node prev = null;
		Node node = head;
		
		if (node != null) {
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			
			if (node.next == null)
				reverseHead = node;
			else
				return recursionlyReverseList(node);
			
		} 
		return reverseHead;
	}
	
	class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}
	
	private void connectedNode(Node n1, Node n2, Node n3, Node n4, Node n5) {
		if (n1 == null) return;
		
		if (n1.next == null)			
			n1.next = n2;
		
		if (n2 == null) return;
		if (n2.next == null)	
			n2.next = n3;
		
		if (n3 == null) return;
		if (n3.next == null)	
			n3.next = n4;
		
		if (n4 == null) return;
		if (n4.next == null)	
			n4.next = n5;
		
		if (n5 == null) return;
		if (n5.next == null)	
			n5.next = null;
	}
	
	// 输入的链表有多个结点
	@Test
	public void test1() throws Exception {
		Node n1 = new Node(1); 
		Node n2 = new Node(2); 
		Node n3 = new Node(3); 
		Node n4 = new Node(4); 
		Node n5 = new Node(5);
		connectedNode(n1, n2, n3, n4, n5);
		
		// Node reverseHead = reverseList(n1);
		Node reverseHead = recursionlyReverseList(n1);
		if (reverseHead != null)
			System.out.println("value=" + reverseHead.value);
	}
	
	// 输入的链表只有一个结点
	@Test
	public void test2() throws Exception {
		Node n1 = new Node(1); 
		connectedNode(n1, null, null, null, null);
		
		Node reverseHead = reverseList(n1);
		if (reverseHead != null)
			System.out.println("value=" + reverseHead.value);
	}
	
	// 输入空链表
	@Test
	public void test3() throws Exception {
		Node reverseHead = reverseList(null);
		if (reverseHead != null)
			System.out.println("value=" + reverseHead.value);
	}
}
