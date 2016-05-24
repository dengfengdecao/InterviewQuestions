package me.dengfengdecao.tree;

/**
 * 将二叉搜索树转换成排序的双向链表,要求不能增加新节点,只能调整指针方向:
 * 用递归中序遍历二叉搜索树,即可得到排序的链表,在遍历到根节点时,将左子树中最大的节点指向根节点,
 * 然后将链表的尾节点指向根节点,最后遍历右子树,找到最小的节点,将根节点指向最小阶段.
 * @author linyu
 *
 */
public class ConvertBinarySearchTree {

	TreeNode convert(TreeNode rootOfTree) {
		// lastNodeInList指向双向链表的尾结点
		TreeNode lastNodeInList = null;
		// 指向链表头节点
		TreeNode headOfList = lastNodeInList;		
		convertNode(rootOfTree, lastNodeInList);
		while (headOfList != null && lastNodeInList != null)
			headOfList = headOfList.left;
			
		return headOfList;
	}

	// 原先指向左子节点的指针调整为链表中指向前一个节点的指针,
	// 原先指向右子节点的指针调整为链表中指向后一个节点的指针
	private void convertNode(TreeNode rootOfTree, TreeNode lastNodeInList) {
		if (rootOfTree == null) return;
		
		TreeNode current = rootOfTree;
		if (current.left != null)
			convertNode(current.left, lastNodeInList);
		
		current.left = lastNodeInList;
		if (lastNodeInList != null)
			lastNodeInList.right = current;
		
		lastNodeInList = current;
		
		if (current.right != null)
			convertNode(current.right, lastNodeInList);
	}
}
