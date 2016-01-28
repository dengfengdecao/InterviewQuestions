package me.dengfengdecao.tree;

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
	
	private TreeNode root;
	
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
				if (node.left == null) {	// 如果左子树为空则实例化一个
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

	
	
}
