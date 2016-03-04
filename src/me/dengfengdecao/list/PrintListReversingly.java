package me.dengfengdecao.list;

import java.util.Stack;

import org.junit.Test;

import me.dengfengdecao.list.ReverseList.Node;

/**
 * 输入链表的头节点，从尾到头打印出各节点的值
 * @author linyu
 *
 */

public class PrintListReversingly {
	
	// 迭代 
	void printListReversingly(ListNode head) {
		Stack<ListNode> nodes = new Stack<ListNode>();
		
		ListNode node = head;
		while (node != null) {
			nodes.push(node);	// 推入栈顶
			node = node.next;	// 将头节点的下一个节点赋给当前节点
		}
		
		while (!nodes.isEmpty()) {
			node = nodes.peek();	// 将栈顶节点赋给当前节点并打印
			System.out.print(node.data + "\t");
			nodes.pop();	// 栈顶节点出栈
		}		
	}
	
	// 递归,逆序打印链表
	void printListReverseRecursionly(ListNode head) {		
		if (head == null) return;
		
		ListNode node = head;
		if (node != null) 			
			printListReverseRecursionly(node.next);	// 递归调用一次就在虚拟机栈分配一个栈帧
		
		System.out.print(node.data + "\t");
	}
	
	class ListNode {
		int data;
	    ListNode next;
		public ListNode(int data) {
			super();
			this.data = data;
		}
	    
	}
	
	ListNode buildList(int n) {			
		ListNode head = null;
		ListNode cur = null;
		for (int i = 1; i <= n; i++) {			
			ListNode tmp = new ListNode(i);
			if (i == 1) {
				head = tmp;
			} else if (i == 2) {
				head.next = tmp;				
			} else {
				cur.next = tmp;
			}
			cur = tmp;	// 缓存当前节点
		}	
		
		return head;		
	}
	
	private void printNode(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.data + "\t");
			node = node.next;
		}
		System.out.println();
	}
	
	@Test
	public void test1() {
		ListNode head = buildList(5);
		System.out.println("链表打印前:");
		printNode(head);
		System.out.println("逆序打印链表:");		
		printListReversingly(head);
	}
	
	@Test
	public void test2() {
		ListNode head = buildList(5);
		System.out.println("链表打印前:");
		printNode(head);
		System.out.println("递归逆序打印链表:");		
		printListReverseRecursionly(head);
	}
}
