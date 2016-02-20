package me.dengfengdecao.tree;

/**
 * 在树A中查找树B,若找到则树B是树A的子结构.
 * @author linyu
 *
 */
public class SubstructureInTree {

	boolean hasSubtree(TreeNode root1, TreeNode root2) {		
		boolean result = false;
		
		if (root1 != null && root2 != null) {
			if (root1.value == root2.value)
				result = tree1HasTree2(root1, root2);	// 判断树A中是否有树B
			
			// 递归判断树A中是否有和树B根相同的节点
			if (!result)
				result = hasSubtree(root1.left, root2);
			if (!result) 
				result = hasSubtree(root1.right, root2);
		}
		
		return result;
	}

	private boolean tree1HasTree2(TreeNode root1, TreeNode root2) {
		// 达到树A或树B的叶节点
		if (root2 == null) return true;
		
		if (root1 == null) return false;
		
		if (root1.value != root2.value) return false;

		// 递归遍历树A和树B的左右节点
		return tree1HasTree2(root1.left, root2.left) &&
				tree1HasTree2(root1.right, root2.right);
	}
}
