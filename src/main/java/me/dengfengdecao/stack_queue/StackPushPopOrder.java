package me.dengfengdecao.stack_queue;

import java.util.Stack;

/**
 * 两个整数序列,一个为压栈序列,判断另一个序列是否为该压栈的弹出序列(序列数字各不相同):
 * 如果下一个弹出的数字刚好是栈顶元素则直接弹出,如果下一个弹出的数字不在栈顶则把压栈序列中
 * 还没入栈的数字压入辅助栈,直到把下一个需弹出的数字压入栈顶为止.若所有元素都入栈还没找到下一个弹出的
 * 数字则该序列不是弹出序列.
 * @author linyu
 *
 */
public class StackPushPopOrder {

	boolean isPopOrder (int[] push, int[] pop) {
		Stack<Integer> data = new Stack<Integer>();
		boolean possible = false;
		if (push != null && pop != null) {
			int nextPushIdx = 0;	// 入栈序列索引
			int nextPopIdx = 0;		// 出栈序列索引
			while (nextPopIdx < pop.length) {
				// 当辅助栈的栈顶元素不是要弹出的元素
	            // 先压入一些数字入栈
				while (data.empty() || data.peek() != pop[nextPopIdx]) {
					// 如果所有数字都压入辅助栈了，退出循环
					if (nextPushIdx == push.length - 1)
						break;
					
					data.push(push[nextPushIdx]);
					nextPushIdx++;
				}
				
				if (data.peek() != pop[nextPopIdx])
					break;
				
				data.pop();
				nextPopIdx++;
			}
			
			if (data.empty() && nextPopIdx == pop.length - 1)
				possible = true;
		}
		return possible;
	}
}
