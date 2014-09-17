package dataStructure;

public class TreeNode {
	private int data;
	private TreeNode lchild;
	private TreeNode rchild;
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLchild() {
		return lchild;
	}

	public void setLchild(TreeNode lchild) {
		this.lchild = lchild;
	}

	public TreeNode getRchild() {
		return rchild;
	}

	public void setRchild(TreeNode rchild) {
		this.rchild = rchild;
	}
	
	/**
	 * 获得右子树中最小的值
	 * @return
	 */
	public TreeNode getHead(){
		TreeNode head = this;
		while(true){
			if(this.getLchild()!=null){
				head = head.getLchild();
			}else{
				break;
			}
		}
		return head;
	}
	
	public TreeNode getTail(){
		TreeNode tail = this;
		while(true){
			if(tail.getRchild()!=null){
				tail = tail.getRchild();
			}else{
				break;
			}
		}
		return tail;
	}
	
	public void convert(){
		if(lchild != null){
			TreeNode recordTail = lchild.getTail();
			lchild.convert();
			
			recordTail.rchild = this;
			lchild = recordTail;
		}
		if(rchild != null){
			TreeNode recordHead = rchild.getHead();
			rchild.convert();
			
			recordHead.lchild = this;
			rchild = recordHead;
		}
	}

}
