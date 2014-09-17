package others;

import dataStructure.Stack;
import dataStructure.Tree;
import dataStructure.TreeNode;

/**
 * @author elloooooo
 * 寻找一棵给定二叉树，从根节点到叶子节点何为某一常数的所有路径
 *
 */
public class FindTreeRoute {
	//利用一个栈，保存探索过的节点路径，这个栈也可以使用数组，外加一个top，表示栈顶的下标实现
	Stack<Integer> routeStack = new Stack<Integer>();
	//该函数，寻找到给定节点node，路径和为value的路径
	public void findTreeRoute(TreeNode node,int value){
		//将当前访问的节点压栈
		routeStack.push(node.getData());
		//从和中减去当前节点的值
		value -= node.getData();
		//如果当前节点为叶子节点，则尝试判断当前路径和是否已减为0，即路径和与要求的值相同
		if(node.getLchild()==null&&node.getRchild()==null){
			if(value==0){
				//如果相同，则打印路径，即输出栈中的元素，注意，此时不是pop元素，而只是按照pop顺序，打印里面的元素
				printPath();
			}
		}else{
			//不是叶子节点，则递归调用本函数
			if(node.getLchild()!=null){
				findTreeRoute(node.getLchild(), value);
			}
			if(node.getRchild()!=null){
				findTreeRoute(node.getRchild(), value);
			}
		}
		//函数返回前要将如栈元素弹出，值加回去，达到搜算完一条路径后，回溯到前一个节点的效果
		routeStack.pop();
		value+= node.getData();
	}
	
	private void printPath() {
		routeStack.showStack();
	}
	
	public static void main(String[] args) {
		int[] dataSet = { 10,5,4,7,12};
		Tree tree = new Tree();
		tree.createTreeNodeFromArray(dataSet);
		FindTreeRoute findTreeRoute = new FindTreeRoute();
		findTreeRoute.findTreeRoute(tree.getRoot(),22);

	}

}
