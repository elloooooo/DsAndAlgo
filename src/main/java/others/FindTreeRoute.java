package others;

import dataStructure.Stack;
import dataStructure.Tree;
import dataStructure.TreeNode;

/**
 * @author elloooooo
 * Ѱ��һ�ø������������Ӹ��ڵ㵽Ҷ�ӽڵ��Ϊĳһ����������·��
 *
 */
public class FindTreeRoute {
	//����һ��ջ������̽�����Ľڵ�·�������ջҲ����ʹ�����飬���һ��top����ʾջ�����±�ʵ��
	Stack<Integer> routeStack = new Stack<Integer>();
	//�ú�����Ѱ�ҵ������ڵ�node��·����Ϊvalue��·��
	public void findTreeRoute(TreeNode node,int value){
		//����ǰ���ʵĽڵ�ѹջ
		routeStack.push(node.getData());
		//�Ӻ��м�ȥ��ǰ�ڵ��ֵ
		value -= node.getData();
		//�����ǰ�ڵ�ΪҶ�ӽڵ㣬�����жϵ�ǰ·�����Ƿ��Ѽ�Ϊ0����·������Ҫ���ֵ��ͬ
		if(node.getLchild()==null&&node.getRchild()==null){
			if(value==0){
				//�����ͬ�����ӡ·���������ջ�е�Ԫ�أ�ע�⣬��ʱ����popԪ�أ���ֻ�ǰ���pop˳�򣬴�ӡ�����Ԫ��
				printPath();
			}
		}else{
			//����Ҷ�ӽڵ㣬��ݹ���ñ�����
			if(node.getLchild()!=null){
				findTreeRoute(node.getLchild(), value);
			}
			if(node.getRchild()!=null){
				findTreeRoute(node.getRchild(), value);
			}
		}
		//��������ǰҪ����ջԪ�ص�����ֵ�ӻ�ȥ���ﵽ������һ��·���󣬻��ݵ�ǰһ���ڵ��Ч��
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
