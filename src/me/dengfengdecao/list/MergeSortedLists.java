package me.dengfengdecao.list;

import org.junit.Test;

/**
 * 合并两个递增的排序链表,使合并后的链表也是升序的.
 * 递归比较两个递增链表的头节点,将小的放到合并链表的后面.
 * 
 * @author linyu
 *
 */
public class MergeSortedLists {

	Node merge(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;		
		
		Node mergeHead = null;
		if (head1.value < head2.value) {
			mergeHead = head1;
			mergeHead.next = merge(head1.next, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = merge(head1, head2.next);
		}
		
		return mergeHead;
	}
	
	// 构建单链表
	// n从1开始,返回头节点
	Node buildList(Node[] nodeArray) {	
		if (nodeArray == null) return null;
		
		Node head = nodeArray[0];
		Node cur = null;
		for (int i=1; i < nodeArray.length; i++) {			
			Node tmp = nodeArray[i];
			if (i == 1) {
				head.setNext(tmp);				
			} else {
				cur.setNext(tmp);
			}
			cur = tmp;	// 缓存当前节点
		}	
		
		return head;		
	}
	
	class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			super();
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}

	// list1: 1->3->5
	// list2: 2->4->6
	@Test
	public void test1() throws Exception {
		Node[] node1 = {new Node(1), new Node(3), new Node(5)};
		Node[] node2 = {new Node(2), new Node(4), new Node(6)};
		Node head1 = buildList(node1);
		Node head2 = buildList(node2);
		Node mergeHead = merge(head1, head2);
		System.out.println("value of merge head:");
		while (mergeHead != null) {
			System.out.print(mergeHead.value + ",");
			mergeHead = mergeHead.getNext();
		}
	}
	// list1: 1->3->5
	// list2: 1->3->5
	@Test
	public void test2() throws Exception {
		Node[] node1 = {new Node(1), new Node(3), new Node(5)};
		Node[] node2 = {new Node(1), new Node(3), new Node(5)};
		Node head1 = buildList(node1);
		Node head2 = buildList(node2);
		Node mergeHead = merge(head1, head2);
		System.out.println("value of merge head:");
		while (mergeHead != null) {
			System.out.print(mergeHead.value + ",");
			mergeHead = mergeHead.getNext();
		}
	}
	// list1: 1
	// list2: 2
	@Test
	public void test3() throws Exception {
		Node[] node1 = {new Node(1)};
		Node[] node2 = {new Node(2)};
		Node head1 = buildList(node1);
		Node head2 = buildList(node2);
		Node mergeHead = merge(head1, head2);
		System.out.println("value of merge head:");
		while (mergeHead != null) {
			System.out.print(mergeHead.value + ",");
			mergeHead = mergeHead.getNext();
		}
	}
	
	// 一个链表为空
	// list1: 1->3->5
	// list2: null
	@Test
	public void test4() throws Exception {
		Node[] node1 = {new Node(1), new Node(3), new Node(5)};
		Node[] node2 = null;
		Node head1 = buildList(node1);
		Node head2 = buildList(node2);
		Node mergeHead = merge(head1, head2);
		System.out.println("value of merge head:");
		while (mergeHead != null) {
			System.out.print(mergeHead.value + ",");
			mergeHead = mergeHead.getNext();
		}
	}
	
	// 两个链表都为空链表
	// list1: 空链表
	// list2: 空链表
	@Test
	public void test5() throws Exception {
		Node head1 = buildList(null);
		Node head2 = buildList(null);
		Node mergeHead = merge(head1, head2);
		System.out.println("value of merge head:");
		while (mergeHead != null) {
			System.out.print(mergeHead.value + ",");
			mergeHead = mergeHead.getNext();
		}	
	}
}
