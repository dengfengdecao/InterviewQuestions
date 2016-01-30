package me.dengfengdecao.tree;

import java.util.Stack;

import org.junit.Test;

public class BinaryTree {
	
	/**
	 * 内部类，节点类
	 * @author linyu
	 *
	 */
	class TreeNode {
		private int value;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
			
		}
		
	}
	
	private TreeNode root;	// 根节点


	/**
	 * 递归构建二叉树
	 * @param node
	 * @param value
	 */
	void buildBinaryTree(TreeNode node, int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			if (node.value > value) {	// 如果值小于根节点的值则放在左子树，否则放在右子树
				if (node.left == null) {	// 如果左子树为空则实例化一个,否则递归构建左子树
					node.left = new TreeNode(value);					
				} else {
					buildBinaryTree(node.left, value);						
				}
			} else {
				if (node.right == null) {
					node.right = new TreeNode(value);
				} else {
					buildBinaryTree(node.right, value);
				}
			}
					
		}
	}

	// 递归前序遍历
	void recursionPreorder(TreeNode node) {
		
		if (node != null) {
			System.out.print(node.value + "\t");
			recursionPreorder(node.left);
			recursionPreorder(node.right);
		}
	}
	
	// 前序遍历
	void preorder(TreeNode node) {
		if (node == null) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();		
		stack.push(node);	// 根节点入栈		
		while (!stack.isEmpty()) {
			TreeNode currentNode = stack.pop();	// 栈顶节点出栈
			System.out.print(currentNode.value + "\t"); // 输出栈顶节点值
			if (currentNode.right != null) {
				stack.push(currentNode.right);	// 后进先出，右子树先进
			}
			if (currentNode.left != null) {		// 左子树后进
				stack.push(currentNode.left);
			} 		
		}
		
	}
	
	// 递归中序遍历
	void recursionInorder(TreeNode node) {
		if (node != null) {
			recursionInorder(node.left);
			System.out.print(node.value + "\t");
			recursionInorder(node.right);
		}
	}
	
	// 中序遍历
	void inorder(TreeNode node) {
		// TODO:待实现
		if (node == null) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();	
		while (node != null) {
			while (node.right != null) {	
				stack.push(node.right);// 当前节点右子树入栈				
				stack.push(node);	// 当前节点入栈
				if (node.left != null) {
					node = node.left;	// 将当前节点的左子树赋给当前节点					
				} else {
					node = node.right;
				}
			}
			
			node = stack.pop();	// 将当前节点的栈顶节点（根）出栈

			while (node.left != null) {				
				stack.push(node.left);								
				stack.push(node);
				if (node.left != null) {
					node = node.left;	// 将当前节点的左子树赋给当前节点					
				} else {
					node = node.right;
				}
			}
		}
					
		while (!stack.isEmpty()) {	// 栈不为空
			node = stack.pop();
			System.out.print(node.value + "\t");
		}					
	}
	
	
	// 递归后序遍历
	void recursionPostorder(TreeNode node) {
		if (node != null) {
			recursionPostorder(node.left);
			recursionPostorder(node.right);
			System.out.print(node.value + "\t");
		}
	}
	
	
	
	// ======================================= 测试用例 =======================================
	// 用例1:递归先序遍历
	@Test
	public void test1() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		System.out.println("递归先序遍历：");
		recursionPreorder(root);		
	}
	
	// 用例2:递归先序遍历，根为null
	@Test
	public void test2() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		System.out.println("递归先序遍历：");
		recursionPreorder(null);		
	}
	
	
	// 用例3：非递归先序遍历
	@Test
	public void test3() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("非递归先序遍历：");
		preorder(root);
	}
	
	// 用例4:先序遍历，根为null
	@Test
	public void test4() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		System.out.println("test4, 非递归先序遍历：");
		preorder(root);	
	}
		
	// 用例5：递归中序遍历
	@Test
	public void test5() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test5, 递归中序遍历：");
		recursionInorder(root);
	}
	
	// 用例6：递归中序遍历，根为null
	@Test
	public void test6() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test6, 递归中序遍历根为null：");
		recursionInorder(null);
	}
	
	// 用例7：非递归中序遍历
	@Test
	public void test7() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test7, 非递归中序遍历：");
		inorder(root);
	}
	
	// 用例8：非递归中序遍历，根为null
	@Test
	public void test8() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test8, 非递归中序遍历根为null：");
		inorder(null);
	}
}
