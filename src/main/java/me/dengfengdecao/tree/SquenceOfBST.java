package me.dengfengdecao.tree;

import org.junit.Test;

public class SquenceOfBST {

	// 输入一个整数数组,判断是否是某二叉搜索树的后序遍历
	boolean verifySquenceOfBST (int[] squence, int length) {
		if (squence == null || squence.length <= 0) return false;
						
		int root = squence[length-1];
		// 左子树比根大则退出循环,此时若数组还有元素则遍历右子树
		int i = 0;
		for (; i < length-1; i++) {
			if (squence[i] > root)
				break;
		}
		
		// 右子树比根小则返回false
		int j = i;
		for (; j < length-1; j++) {
			if (squence[j] < root)
				return false;
		}
		
		// 若有左子树,递归重复上面步骤,处理左子树
		boolean left = true;
		if (i > 0) 
			left = verifySquenceOfBST(squence, i);
		
		
		// 若有右子树,递归重复上面步骤,处理右子树
		boolean right = true;
		if (i < length-1)
			right = verifySquenceOfBST(squence, length-i-1);
		
		return left && right;
	}
	
	//  10
	///      \
	//6        14
	///\        /\
	//4  8     12  16
	@Test
	public void test1() throws Exception {
		int t[] = {4, 8, 6, 12, 16, 14, 10};		
		
		boolean b = verifySquenceOfBST(t, t.length);
		System.out.println("test1 b:" + b);
	}
	
	//  5
	// / \
	//4   7
	//   /
	//  6
	@Test
	public void test2() throws Exception {
		int t[] = {4, 6, 7, 5};
		
		boolean b = verifySquenceOfBST(t, t.length);
		System.out.println("test1 b:" + b);
	}
	
	//  		5
	// 		   /
	//		  4
	//       /
	//		3
	//	   /
	//	  2
	//	 /
	//  1
	@Test
	public void test3() throws Exception {
		int t[] = {1, 2, 3, 4, 5};
		
		boolean b = verifySquenceOfBST(t, t.length);
		System.out.println("test1 b:" + b);
	}
	
	// 1
	//  \
	//   2
	//    \
	//     3
	//      \
	//       4
	//        \
	//         5
	@Test
	public void test4() throws Exception {
		int t[] = {5, 4, 3, 2, 1};
		
		boolean b = verifySquenceOfBST(t, t.length);
		System.out.println("test1 b:" + b);
	}
	
	@Test
	public void test5() throws Exception {
		int t[] = {5};
		
		boolean b = verifySquenceOfBST(t, t.length);
		System.out.println("test1 b:" + b);
	}
	
	@Test
	public void test6() throws Exception {
		int t[] = {7, 4, 6, 5};
		
		boolean b = verifySquenceOfBST(t, t.length);
		System.out.println("test1 b:" + b);
	}
	
}
