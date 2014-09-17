package dsTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	/**
	 * @param root
	 * 输入的树是完全二叉树
	 */
	public void connect(TreeLinkNode root) {
		if(root==null){
			return;
		}
		
		if(root.left!=null&&root.right!=null){
			root.left.next = root.right;
			//这句是关键
			if(root.next!=null){
				root.right.next = root.next.left;
			}
		}
		
		connect(root.left);
		connect(root.right);
		
	}

	
	/**
	 * @param root
	 * 输入的树是任意二叉树
	 * 
	 * 如果像上一题一样，利用先序遍历，那么当链接要横跨左右子树时会发现，由于在企图为左子树建立next指针时，发现左子树的横向链接还没建立，所以失败
	 * 利用 BFS，可以保证上一层的链接建立完全，才进行下一层的链接查找
	 */
	public void connect2(TreeLinkNode root) {
		if(root==null){
			return;
		}
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeLinkNode node = queue.poll();
			
			TreeLinkNode cur = node;
			TreeLinkNode source = null;
			TreeLinkNode target = null;
			
			while(cur.next!=null){
				if(cur.next.left!=null){
					target = cur.next.left;
					break;
				}else if(cur.next.right!=null){
					target = cur.next.right;
					break;
				}else{
					cur = cur.next;
				}
			}
		
			if(node.left!=null&&node.right!=null){
				node.left.next = node.right;
				source = node.right;
			}else if(node.left!=null){
				source = node.left;
			}else if(node.right!=null){
				source = node.right;
			}
			
			if(source!=null&&target!=null){
				source.next = target;
			}
			
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
