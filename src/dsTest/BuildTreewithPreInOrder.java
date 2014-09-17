package dsTest;

/**
 * @author Administrator
 *	Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Answer:
 * 先序遍历中的第一个节点就是根节点，这个节点在中序遍历中将序列划分，左边为左子树的中序遍历，右边为右子数的中序遍历
 * 左子树的中序遍历序列长度为l，则先序遍历第一个节点后面l个元素，为左子树的先序遍历结果，
 * 右子树的中序遍历序列长度为r，则先序遍历序列再后面的r个元素，为右子数先序遍历结果
 * 
 * 依照上面递推关系，就可迭代
 * 
 */
public class BuildTreewithPreInOrder {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//本不想复制数组，仅仅通过传入下标对输入数组进行控制，但是发现下标的计算是在是繁琐，无法调试正确
	/*public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, int pstart, int pend,int istart,int iend) {
		if(istart>iend){
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[pstart]);
		
		if (istart < iend) {
			
			int i = istart;
			while (i < iend) {
				if (inorder[i] == preorder[pstart]) {
					break;
				}
				i++;
			}
			
			root.left = buildTree(preorder, inorder, pstart+1, pstart+i, istart,i-1);
			
			root.right = buildTree(preorder,inorder, i+1,pend,i+1,iend);
		}

		return root;
	}*/
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0){
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		if(preorder.length!=1){
			int index = findRootIndexInInorder(preorder[0],inorder);
			//获得左子树中序遍历序列
			int[] lInorder = new int[index];
			for(int i=0;i<index;i++){
				lInorder[i] = inorder[i];
			}
			//获得左子树先序遍历序列
			int[] lPreorder = new int[index];
			for(int i=0;i<index;i++){
				lPreorder[i] = preorder[i+1];
			}
			root.left = buildTree(lPreorder,lInorder);
			
			//获得右子树中序遍历序列
			int[] rInorder = new int[inorder.length-index-1];
			for(int i=0;i<inorder.length-index-1;i++){
				rInorder[i] = inorder[index+1+i];
			}
			//获得右子树先序遍历结果
			int[] rPreorder = new int[inorder.length-index-1];
			for(int i=0;i<inorder.length-index-1;i++){
				rPreorder[i] = preorder[index+i+1];
			}
			root.right = buildTree(rPreorder,rInorder);
		}
		return root;
	}
	
	
	/**
	 * 查询先序遍历的第一个节点，在中序遍历结果中的下标
	 * @param val
	 * @param inorder
	 * @return
	 */
	private int findRootIndexInInorder(int val, int[] inorder) {
			int index = 0;
			while (index < inorder.length) {
				if (inorder[index] == val) {
					break;
				}
				index++;
			}
		return index;
	}


	public static void main(String[] args) {
		int[] preorder={4,2,1,3,5,6};
		int[] inorder = {1,2,3,4,5,6};
		BuildTreewithPreInOrder b = new BuildTreewithPreInOrder();
		TreeNode root = b.buildTree(preorder, inorder);
	}
	
	

}
