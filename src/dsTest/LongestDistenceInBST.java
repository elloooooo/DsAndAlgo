package dsTest;

import dataStructure.Tree;
import dataStructure.TreeNode;

/**
 * @author Administrator
 * 如果二叉树视为图，节点A与节点B之间的距离定义为A到根节点的距离（经过的边数）+B到根节点的距离（经过的边数）
 * 求二叉树中距离的最大两个节点之间的距离
 * 
 * 距离最远的两个点，可能是在左子树，也可能倒在右子数，或是一个在左子树，一个在右子数
 */
public class LongestDistenceInBST {
	//获得某一个节点下距离最远的两个节点之间的距离
	public int longestDistence(TreeNode node){
		//空树返回0
		if(node==null){
			return 0;
		}
		//没有孩子节点返回0
		if(node.getLchild()==null&&node.getRchild()==null){
			return 0;
		}
		//左子树的高度
		int lheight = height(node.getLchild());
		//右子树的高度
		int rheight = height(node.getRchild());
		//如果右子树为空，则左子树中最远两点距离与左子树高度(即左子树最深节点与根节点的距离)
		if(node.getLchild()!=null&&node.getRchild()==null){
			return max(longestDistence(node.getLchild()),lheight);
		}
		//如果左子树为空，则右子树中最远两点距离与右子树高度(即右子树最深节点与根节点的距离)
		if(node.getRchild()!=null&&node.getLchild()==null){
			return max(longestDistence(node.getRchild()),rheight);
		}
		
		return max(longestDistence(node.getLchild()),longestDistence(node.getRchild()),lheight+rheight);
	}
	
	private int max(int a, int b, int c) {
		int max = a;
		if(b>max)max=b;
		if(c>max)max=c;
		return max;
	}
	private int max(int a, int b) {
		if(a>b)return a;
		return b;
	}
	
	/**
	 * 获得一个节点为根结点时，该树的高度
	 * @param node
	 * @return
	 */
	private int height(TreeNode node) {
		if(node==null){
			return 0;
		}
		int lheight = height(node.getLchild());
		int rheight = height(node.getRchild());
		if(lheight>rheight){
			return lheight+1;
		}else{
			return rheight+1;
		}
	}
	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] dataSet = { 5, 3, 1, 4, 6 };
		tree.createTreeNodeFromArray(dataSet);
		LongestDistenceInBST l = new LongestDistenceInBST();
		System.out.println(l.longestDistence(tree.getRoot()));
	}

}
