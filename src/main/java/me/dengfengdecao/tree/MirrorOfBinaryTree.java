package me.dengfengdecao.tree;

import org.junit.Test;

/**
 * 输出二叉树的镜像:
 * 根节点不变,交换非叶子节点的左右节点.
 * 先前序遍历树的每个节点,若遍历到的节点有子节点,就交换他的两个子节点,
 * 当交换完所有非叶子节点的左右子节点之后,就得到树的镜像.
 * @author linyu
 *
 */
public class MirrorOfBinaryTree {

	void mirrorRecursively (TreeNode node) {
		if (node  == null) return;
		
		if (node.left != null || node.right != null) {
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		
		if (node.left != null)
			mirrorRecursively(node.left);
		
		if (node.right != null)
			mirrorRecursively(node.right);
	}
	
	void connectTreeNode (TreeNode root, TreeNode left, TreeNode right) {
		root.left = left;
		root.right = right;
	}
	
	private void printTreeNode(TreeNode node) {
		if (node != null) {
			System.out.print(node.value + "、");
		}
		
		if (node.left != null) 
			printTreeNode (node.left);
		
		if (node.right != null)
			printTreeNode (node.right);
		
	}
	
	// 测试完全二叉树：除了叶子节点，其他节点都有两个子节点
	//      8
	//  6      10
	//5   7   9  11
	// 预期结果:
	//		8
	//  10		6
	//11  9	  7   5	
	@Test
	public void test1() throws Exception {
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
		System.out.println("前序遍历输出:");
		printTreeNode(n8);
		System.out.println("\n镜像前序遍历输出:");
		mirrorRecursively(n8);
		printTreeNode(n8);
	}

	// 测试二叉树：除叶子结点之外，左右的结点都有且只有一个左子结点
	// 		 8
	//	   7   
	//	 6 
	//  5
	//4
	@Test
	public void test2() throws Exception {
		TreeNode n8 = new TreeNode(8);
		TreeNode n7 = new TreeNode(7);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		connectTreeNode(n8, n7, null);
		connectTreeNode(n7, n6, null);
		connectTreeNode(n6, n5, null);
		connectTreeNode(n5, n4, null);
		System.out.println("前序遍历输出:");
		printTreeNode(n8);
		System.out.println("\n镜像前序遍历输出:");
		mirrorRecursively(n8);
		printTreeNode(n8);
	}

	// 测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
	//  8
	//   7   
	//    6 
	//     5
	//      4
	@Test
	public void test3() throws Exception {
		TreeNode n8 = new TreeNode(8);
		TreeNode n7 = new TreeNode(7);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		connectTreeNode(n8, null, n7);
		connectTreeNode(n7, null, n6);
		connectTreeNode(n6, null, n5);
		connectTreeNode(n5, null, n4);
		System.out.println("前序遍历输出:");
		printTreeNode(n8);
		System.out.println("\n镜像前序遍历输出:");
		mirrorRecursively(n8);
		printTreeNode(n8);
	}

	// 测试空二叉树：根结点为空指针
	@Test
	public void test4() throws Exception {
		mirrorRecursively(null);
	}
	
	// 测试只有一个结点的二叉树
	@Test
	public void test5() throws Exception {
		TreeNode n = new TreeNode(8);
		mirrorRecursively(n);
	}
}
