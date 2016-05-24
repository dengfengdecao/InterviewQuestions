package me.dengfengdecao.list;

/**
 * 实现一个函数ListNode clone(ListNode head)复制一个复杂链表,
 * 在复杂链表中,每个节点除了有next指向下一个节点,还有一个sibling指向链表的任意节点或null节点.
 * @author linyu
 *
 */
public class CopyComplextList {

	ListNode clone(ListNode head) {
		cloneNodes(head);
		connectSiblingNodes(head);
		return reconnectNodes(head);
	}
	
	// 复制复杂链表所有节点并用next连接
	// 形如:A->A'->B->B'->C->C'->D->D'->E->E'
	void cloneNodes (ListNode head) {
		ListNode node = head;
		while (node != null) {
			ListNode cloneNode = new ListNode(node.value);
			cloneNode.next = node.next;
			cloneNode.sibling = null;			
			
			node.next = cloneNode;	// 连接
			
			node = node.next;
		}
	}
	
	// 连接复杂链表的sibling节点
	// 若元素节点A的sibling连接C则克隆节点A'的sibling连接C的下一节点C'.
	void connectSiblingNodes (ListNode head) {
		ListNode node = head;
		while (node != null) {
			ListNode cloneNode = node.next;
			if (node.sibling != null)
				cloneNode.sibling = node.sibling.next;
			
			node = cloneNode.next;
		}
	}
	
	// 拆分复杂链表,并返回克隆后的复杂链表,奇数节点是元素链表,偶数节点是克隆链表
	// A->A'->B->B'->C->C'->D->D'->E->E'
	ListNode reconnectNodes (ListNode head) {
		ListNode node = head;	// 原始链表头节点
		ListNode cloneHead = null;	// 克隆链表头节点
		ListNode cloneNode = null;	// 当前克隆节点
		
		if (node != null) {
			// 克隆节点的头节点,偶数节点
			cloneHead = cloneNode = node.next; // 第2个节点A'

			node.next = cloneNode.next;	// 第3个节点B,使A->B
			node = node.next;	// B
		}
		
		while (node != null) {
			cloneNode.next = node.next;
			cloneNode = cloneNode.next;
			
			node.next = cloneNode.next;
			node = node.next;
		}
		
		return cloneHead;
	}
}
