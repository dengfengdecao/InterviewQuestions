package me.dengfengdecao.tree;

import java.util.LinkedList;

import org.junit.Test;

public class PrintFromTopToBottomBinaryTree {

	// 从上到下打印二叉树:
	// 实际上是二叉树的层序遍历
	//		8
	//	  /	  \
	//	 6	   10
	//  / \	  /  \
	// 5   7 9	 11	
	void printFromTopToBottom (TreeNode node) {
		if (node == null) return;
		// 定义一个队列来存放二叉树的每个节点
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		// 当队列不为空时,依次打印每个节点
		while (!queue.isEmpty()) {
			// 获取队列头节点并删除
			TreeNode h = queue.remove();
			System.out.print(h.value + "\t");
			
			// 左右节点入队
			if (h.left != null)
				queue.add(h.left);
			
			if (h.right != null)
				queue.add(h.right);
		}
	}
	
	void connectTreeNode (TreeNode root, TreeNode left, TreeNode right) {
		root.left = left;
		root.right = right;
	}
	
	
	@Test
	public void test() throws Exception {
		TreeNode n8 = new TreeNode(8);
		TreeNode n6 = new TreeNode(6);
		TreeNode n10 = new TreeNode(10);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		TreeNode n11 = new TreeNode(11);
		connectTreeNode(n8, n6, n10);
		connectTreeNode(n6, n5, n7);
		connectTreeNode(n10, n9, n11);
		
		printFromTopToBottom(n8);
		
	}
}
