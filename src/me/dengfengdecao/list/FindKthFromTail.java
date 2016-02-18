package me.dengfengdecao.list;

import org.junit.Test;

/**
 * 
 * 查找链表倒数第k个节点
 * 设置两个指针p1, p2,第一个指针p1先走k-1步,然后第二个指针p2指向第一个节点.之后两个
 * 指针同时行走, 当第一个指针到达链表尾节点时,第二个指针刚好指向倒数第k个节点(只遍历链表一次)
 * @author linyu
 *
 */
public class FindKthFromTail {

	
	// 1,头节点为空
	// 2,由于倒数第1个节点k=1,所以k=0,无意义
	// 3,节点数小于k
	Node findKthFromTail(Node head, int k) {
		if (head == null || k == 0)	return null;
		
		Node p1 = head;
		Node p2;
		for (int i = 0; i < k-1; i++) {
			if (p1.next != null)
				p1 = p1.next;
			else 
				return null;
		}
		
		p2 = head;
		while (p1.next != null) {	// 当第一个指针不是指向尾节点时,两个指针开始一起行走
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
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
	// 测试要找的结点在链表中间
	@Test
	public void test1() throws Exception {
		Node n1 = new Node(1); 
		Node n2 = new Node(2); 
		Node n3 = new Node(3); 
		Node n4 = new Node(4); 
		Node n5 = new Node(5);
		connectedNode(n1, n2, n3, n4, n5);
	
		Node n = findKthFromTail(n1, 2);
		System.out.println("value=" + n.value);
	}
	
	// 测试要找的结点是链表的尾结点
	@Test
	public void test2() throws Exception {
		Node n1 = new Node(1); 
		Node n2 = new Node(2); 
		Node n3 = new Node(3); 
		Node n4 = new Node(4); 
		Node n5 = new Node(5);
		connectedNode(n1, n2, n3, n4, n5);
		
		Node n = findKthFromTail(n1, 1);
		System.out.println("value=" + n.value);
	}
	
	// 测试要找的结点是链表的头结点	
	@Test
	public void test3() throws Exception {
		Node n1 = new Node(1); 
		Node n2 = new Node(2); 
		Node n3 = new Node(3); 
		Node n4 = new Node(4); 
		Node n5 = new Node(5);
		connectedNode(n1, n2, n3, n4, n5);
		
		Node n = findKthFromTail(n1, 5);
		System.out.println("value=" + n.value);
	}
	
	// 测试空链表
	@Test
	public void test4() throws Exception {
		Node n = findKthFromTail(null, 2);
		if (n != null)
			System.out.println("value=" + n.value);
	}
	
	// 测试输入的第二个参数k大于链表的结点总数
	@Test
	public void test5() throws Exception {
		Node n1 = new Node(1); 
		Node n2 = new Node(2); 
		Node n3 = new Node(3); 
		Node n4 = new Node(4); 
		Node n5 = new Node(5);
		connectedNode(n1, n2, n3, n4, n5);
		
		Node n = findKthFromTail(n1, 6);
		if (n != null)
			System.out.println("value=" + n.value);
	}
	
	// 测试输入的第二个参数k为0
	@Test
	public void test6() throws Exception {
		Node n1 = new Node(1); 
		Node n2 = new Node(2); 
		Node n3 = new Node(3); 
		Node n4 = new Node(4); 
		Node n5 = new Node(5);
		connectedNode(n1, n2, n3, n4, n5);
		
		Node n = findKthFromTail(n1, 0);
		if (n != null)
			System.out.println("value=" + n.value);
	}
	
}
