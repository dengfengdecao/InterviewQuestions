package me.dengfengdecao.list;

import org.junit.Test;

public class DeleteNodeInList {

	/**
	 * 在0(1)时间删除链表节点
	 * 3中情况:
	 * 	1,删除的节点不是尾节点
	 * 	2,删除的节点是头节点
	 * 	3,删除的节点是尾节点 
	 * @param head 链表的头指针
	 * @param toBeDelete 节点指针,要在O(1)时间删除
	 */
	void deleteNode(Node head, Node toBeDelete) {		
		if (head == null || toBeDelete == null)
			return;				
		
		 // 要删除的结点不是尾结点
		if (toBeDelete.next != null) { // 下一个节点覆盖当前要删除的节点并删除下一个节点
			Node theNext = toBeDelete.next;		// 当前要删除节点的下一节点
			toBeDelete.value = theNext.value; // 将下一节点的值赋给当前要删除的节点
			toBeDelete.next = theNext.next;	
			
			theNext = null; // 覆盖最后一步,删除当前要删除节点的下一节点
		} else if (head == toBeDelete) { // 链表只有一个结点，删除头结点（也是尾结点）
			toBeDelete = null;
			head = null;
		} else { // 链表中有多个结点，要删除的节点是尾结点
			Node node = head;	// 缓存头节点
			// 遍历链表,使其指向尾节点
			while (node.next != toBeDelete) 
				node = node.next;
			
			node.next = null;
			toBeDelete = null;
		}
		
		System.out.println("\n删除后:");
		printNode(head);
	}
	
	// 节点定义
	class Node {
		private int value;
		private Node next;	// 要删除的节点的下一节点
		public Node(int value) {
			this.value = value;
			this.next = null;
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
	
	private void printNode(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + ",");
			node = node.next;
		}
	}
	@Test
	public void test1() throws Exception {
		Node n1 = new Node(1);
		connectedNode(n1, null, null, null, null);
		
		System.out.println("删除前:");
		printNode(n1);
		deleteNode(n1, n1);
		
	}
	
	@Test
	public void test2() throws Exception {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		
		connectedNode(n1, n2, n3, n4, n5);
		System.out.println("删除前:");
		printNode(n1);
		deleteNode(n1, n5);
	}
	
	@Test
	public void test3() throws Exception {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		connectedNode(n1, n2, n3, n4, n5);
		System.out.println("删除前:");
		printNode(n1);
		deleteNode(n1, n3);
	}


	@Test
	public void test4() throws Exception {
		Node n1 = new Node(1);
		
		connectedNode(n1, null, null, null, null);
		
		System.out.println("删除前:");
		printNode(n1);
		deleteNode(n1, null);
	}

}
