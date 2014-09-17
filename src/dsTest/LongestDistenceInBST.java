package dsTest;

import dataStructure.Tree;
import dataStructure.TreeNode;

/**
 * @author Administrator
 * �����������Ϊͼ���ڵ�A��ڵ�B֮��ľ��붨��ΪA�����ڵ�ľ��루�����ı�����+B�����ڵ�ľ��루�����ı�����
 * ��������о������������ڵ�֮��ľ���
 * 
 * ������Զ�������㣬����������������Ҳ���ܵ���������������һ������������һ����������
 */
public class LongestDistenceInBST {
	//���ĳһ���ڵ��¾�����Զ�������ڵ�֮��ľ���
	public int longestDistence(TreeNode node){
		//��������0
		if(node==null){
			return 0;
		}
		//û�к��ӽڵ㷵��0
		if(node.getLchild()==null&&node.getRchild()==null){
			return 0;
		}
		//�������ĸ߶�
		int lheight = height(node.getLchild());
		//�������ĸ߶�
		int rheight = height(node.getRchild());
		//���������Ϊ�գ�������������Զ����������������߶�(������������ڵ�����ڵ�ľ���)
		if(node.getLchild()!=null&&node.getRchild()==null){
			return max(longestDistence(node.getLchild()),lheight);
		}
		//���������Ϊ�գ�������������Զ����������������߶�(������������ڵ�����ڵ�ľ���)
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
	 * ���һ���ڵ�Ϊ�����ʱ�������ĸ߶�
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
