package me.dengfengdecao.other.list;

import org.junit.Test;

/**
 *  链表是一种动态的数据结构，因为在创建链表时，我们不需要知道链表的长度，当插入一个结点时，只需要为该结点分配内存，然后调整指针的指向来确保新结点被连接到链表中。所以，它不像数组，内存是一次性分配完毕的，
 *  而是每添加一个结点分配一次内存。正是因为这点，所以它没有闲置的内存，比起数组，空间效率更高。
 * @author linyu
 *
 */
public class AddOrRemoveInList {

	// 往链表的末尾添加一个结点
	void addToTail (ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;			
		} else {
			// 迭代指向当前节点的下一节点,若当前节点的next指针为空则到达链表末尾,此时插入新节点
			ListNode node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
		
		print(head);
	}
	
	// 往链表的头部移除一个结点
	// 就因为链表的内存不是一次性分配的，所以它并不像数组一样，内存是连续的，所以如果我们想要在链表中查找某个元素，
	// 我们就只能从头结点开始，而不能像数组那样根据索引来，所以时间效率为O(N)。
	ListNode removeFromList(ListNode head, int value) {
		if (head == null) return null;
		
		ListNode toBeDelete = null;
		ListNode prev = null;
		ListNode node = head;
		ListNode next = null;
		
		while (node != null) {
			// 找到则从链表删除该节点
			if (node.value == value && node == head) {
				// 要删除的节点是头节点								
				node.next = null;
				toBeDelete = node;	
				node = null;												
			} else if (node.value == value){
				// 要删除的节点不在头部
				toBeDelete = node;		
				next = toBeDelete.next;	// 得到当前要删除节点指向的下一节点
				prev.next = next;	// 
				toBeDelete.next = null;
				node = null;
			} else {
				prev = node;	// 缓存上一个节点
				node = node.next;
			}
		}
		
		return toBeDelete;
	}
	

	private void print(ListNode head) {
		ListNode node = head;
		if (node != null) {
			System.out.print(node.value + "\t");
			print(node.next);
		}
		
	}

	// 构建单链表
	// n从1开始,返回头节点
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
		
		
	@Test
	public void test1() throws Exception {
		addToTail(null, 1);
		addToTail(new ListNode(2), 3);
		addToTail(new ListNode(4), 5);
	}
	
	@Test
	public void test2() throws Exception {
		ListNode head = buildList(5);
		ListNode toBeDelete = removeFromList(head, 1);
		if (toBeDelete != null)
			print(toBeDelete);
	}
	
	@Test
	public void test3() throws Exception {
		ListNode head = buildList(5);
		ListNode toBeDelete = removeFromList(head, 5);
		if (toBeDelete != null)
			print(toBeDelete);
	}
	
	@Test
	public void test4() throws Exception {
		ListNode head = buildList(5);
		ListNode toBeDelete = removeFromList(head, 3);
		if (toBeDelete != null)
			print(toBeDelete);
	}
	
	@Test
	public void test5() throws Exception {
		ListNode head = buildList(5);
		ListNode toBeDelete = removeFromList(head, 0);
		if (toBeDelete != null)
			print(toBeDelete);
	}
	
	@Test
	public void test6() throws Exception {
		ListNode toBeDelete = removeFromList(null, 0);
		if (toBeDelete != null)
			print(toBeDelete);
	}
}
