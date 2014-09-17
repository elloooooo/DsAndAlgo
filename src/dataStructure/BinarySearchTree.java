package dataStructure;

//? super T 限定T是一个实现了泛型Comparable接口的类型，这个泛型Comparable可以对T以及T的超类进行比较
public class BinarySearchTree<T extends Comparable<? super T>> {
	private static class BinaryNode<T>{
		T value;
		BinaryNode<T> lchild;
		BinaryNode<T> rchild;
		
		BinaryNode(T theElement){
			this(theElement,null,null);
		}
		BinaryNode(T theElement, BinaryNode lt,BinaryNode rt){
			value = theElement;
			lchild = lt;
			rchild = rt;
		}
	}
	
	private BinaryNode<T> root;
	
	public void makeEmpty(){
		root = null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	
	//查找某一值得节点
	public BinaryNode<T> search(T x){
		return search(x, root);
	}
	
	//是否包含一个元素
	public boolean contains(T x){
		return contains(x,root);
	}
	
	public T findMin() throws UnderflowException{
		if(isEmpty()){
			throw new UnderflowException();
		}else{
			return findMin(root);
		}
	}
	public T findMax() throws UnderflowException{
		if(isEmpty()){
			throw new UnderflowException();
		}else{
			return findMax(root);
		}
	}
	public void insert(T x){
		root = insert(x,root);
	}
	public void remove(T x){
		root = remove(x,root);
	}
	public void printTree(){
		
	}
	
	
	/**
	 * @param x 要移除的元素
	 * @param root 树根或 子树的根
	 * @return 移除要移除的元素后的新树的根节点
	 */
	private BinaryNode<T> remove(T x, BinaryNode<T> root) {
		//未找到要删除的节点
		if(root==null){
			return root;
		}
		//用于判断要删除的节点在左子树，还是右子树
		int compareRes = x.compareTo(root.value);
		
		if(compareRes<0){
			//在左子树删除，新树作为根的左子树
			root.lchild = remove(x,root.lchild);
		}else if(compareRes>0){
			//在右子树删除，新树作为根的右子树
			root.rchild = remove(x,root.rchild);
		}else{
			//要删除的元素就是跟元素，则需要判断，根元素有几个孩子
			//如果有两个孩子
			if(root.lchild!=null&&root.rchild!=null){
				//用右子数中最小的节点值，替换根节点值
				root.value = findMin(root.rchild);
				//在右子数中删除这个最小值，因为最小值一定没有左孩子，所以递归调用remove时，一定会走下面的分支
				root.rchild = remove(root.value, root.rchild);
			}else{
				//如果有左孩子，无右孩子，就用左孩子替换自己，如果没有，则用右孩子替换自己，当然右孩子也可能为空，就相当于无孩子时只是用将root设为null
				root = (root.lchild!=null)?root.lchild:root.rchild;
			}
		}
		return root;
	}
	
	private BinaryNode<T> insert(T x, BinaryNode<T> root) {
		if(root==null){
			root =  new BinaryNode<T>(x);
		}else{
			int compareRes = x.compareTo(root.value);
			if(compareRes>0){
				insert(x,root.rchild);
			}else if(compareRes<0){
				insert(x,root.lchild);
			}else{
				;
			}
		}
		return root;
	}
	private T findMax(BinaryNode<T> root) {
		if(root.rchild==null){
			return root.value;
		}else{
			return findMax(root.rchild);
		}
	}
	private T findMin(BinaryNode<T> root) {
		if(root.lchild==null){
			return root.value;
		}else{
			return findMax(root.lchild);
		}
	}
	private boolean contains(T x, BinaryNode<T> root) {
		if(root==null){
			return false;
		}
		int compareRes = x.compareTo(root.value);
		if(compareRes>0){
			return contains(x,root.rchild);
		}else if(compareRes<0){
			return contains(x,root.lchild);
		}else{
			return true;
		}
	}
	private BinaryNode<T> search(T x, BinaryNode<T> root){
		if(root==null){
			return null;
		}
		int compareRes = x.compareTo(root.value);
		if(compareRes<0){
			return search(x,root.lchild);
		}else if(compareRes>0){
			return search(x,root.rchild);
		}else{
			return root;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
