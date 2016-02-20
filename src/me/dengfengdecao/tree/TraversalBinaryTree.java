package me.dengfengdecao.tree;

import java.util.Stack;

import org.junit.Test;

/**
 * 递归和非递归方式遍历二叉树
 * @author linyu
 *
 */
public class TraversalBinaryTree {
	
	/**
	 * 内部类，节点类
	 * @author linyu
	 *
	 
	class TreeNode {
		private int value;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
			this.left = null;
			this.right = null;		
		}				
	}*/
	
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
		while (!stack.empty()) {
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
		if (node == null) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();	
		while (node != null || stack.size() > 0) {
			while (node != null) {	
				stack.push(node);	// 根入栈
				node = node.left;	// 左子树依次入栈
			}
			
			// 左子树全部入栈后即出栈，若栈顶还有节点继续出栈
			if (stack.size() > 0) {	
				node = stack.pop();
				System.out.print(node.value + "\t");
				// 将栈顶节点的右子树赋给当前节点
				node = node.right;
			}					
			
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
	
	// 后序遍历，双栈法
	void postorder(TreeNode node) {
		if (node == null) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();    
	    Stack<TreeNode> temp = new Stack<TreeNode>();    
	
	    while (node != null || stack.size() > 0) {    
	        while (node != null) {    
	            temp.push(node);    
	            stack.push(node);    
	            node = node.right;   // 右子树先入栈 
	        }    
	        
	        if (stack.size() > 0) {    
	            node = stack.pop();    
	            node = node.left;    // 右叶子的父节点的左节点赋给当前节点
	        }    
	    }    
	    while (temp.size() > 0) {	// 把插入序列都插入到了temp 
	        node = temp.pop();    
	        System.out.print(node.value + "\t");    
	    }    
		
			
	}
	
	
	// ======================================= 测试用例 =======================================
	/*
	 * 			  2
	 * 		    /	\
	 * 	       1      4
	 * 					\
	 * 					 12
	 * 					/	\
	 * 				   6	 45
	 * 						/	\
	 * 					   21	111	
	 * 			   
	 */
	// 用例1:递归先序遍历
	// 预期结果：2，1，4，12，6，45，21，111 
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
	// 预期结果：2，1，4，12，6，45，21，111 
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
	// 预期结果：1,2,4,6,12,21,45，111
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
	// 预期结果：1,2,4,6,12,21,45，111
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
	
	// 用例9：递归后序遍历
	// 预期结果：1,6,21,111,45,12,4,2
	@Test
	public void test9() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test9, 递归后序遍历：");
		recursionPostorder(root);
	}
	// 用例10：递归后序遍历，根为空
	@Test
	public void test10() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test10, 递归后序遍历，根为空：");
		recursionPostorder(null);
	}
	
	// 用例11：非递归后序遍历
	// 预期结果：1,6,21,111,45,12,4,2
	@Test
	public void test11() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test11, 非递归后序遍历：");
		postorder(root);
	}
	// 用例12：递归后序遍历，根为空
	@Test
	public void test12() {
		int t[] = {2, 4, 12, 45, 21, 6, 111, 1}; 
		for (int i=0; i<t.length; i++) {
			buildBinaryTree(root, t[i]);
		}
		
		System.out.println("test12, 递归后序遍历，根为空：");
		postorder(null);
	}
}
