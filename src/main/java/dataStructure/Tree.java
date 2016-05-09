package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dsTest.LongestDistenceInBST;

public class Tree {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	/**
	 * 按先序遍历将数组构造为二叉树
	 * 
	 * @param dataSet
	 */
	public void createTreeNodeFromArray(int[] dataSet) {
		for (int i = 0; i < dataSet.length; i++) {
			insert(dataSet[i]);
		}
	}

	private void insert(int i) {
		root = insert(root, i);
	}

	private TreeNode insert(TreeNode node, int i) {
		if (node == null) {
			node = new TreeNode();
			node.setData(i);
		} else {
			if (i < node.getData()) {
				node.setLchild(insert(node.getLchild(), i));
			} else {
				node.setRchild(insert(node.getRchild(), i));
			}
		}
		return node;
	}

	// 先序遍历构造二叉树，无子节点则输入-1
	private TreeNode createTreeByInput(TreeNode node) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(br.readLine());
		if (val != -1) {
			if (node == null) {
				node = new TreeNode();
			}
			node.setData(val);
			node.setLchild(createTreeByInput(node.getLchild()));
			node.setRchild(createTreeByInput(node.getRchild()));
		}
		return node;
	}

	// 中序遍历输出
	public void showTree(TreeNode root) {
		if (root != null) {
			showTree(root.getLchild());
			System.out.println(root.getData());
			showTree(root.getRchild());
		}
	}
	
	public void showLinkedList(TreeNode root){
		System.out.println(root.getData());
		System.out.println("To left：");
		TreeNode midNode = root;
		while(midNode.getLchild()!=null){
			System.out.println(midNode.getLchild().getData());
			midNode = midNode.getLchild();
		}
		midNode = root;
		System.out.println("To right:");
		while(midNode.getRchild()!=null){
			System.out.println(midNode.getRchild().getData());
			midNode = midNode.getRchild();
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Tree tree = new Tree();
//		TreeNode root = null; root = tree.createTreeByInput(root);
		int[] dataSet = { 5, 3, 1, 4, 6 };
		tree.createTreeNodeFromArray(dataSet);
		tree.showTree(tree.root);
		
		/*tree.root.convert();
		tree.showLinkedList(tree.root);*/
	}
}
