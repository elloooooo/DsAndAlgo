package dataStructure;

//? super T �޶�T��һ��ʵ���˷���Comparable�ӿڵ����ͣ��������Comparable���Զ�T�Լ�T�ĳ�����бȽ�
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
	
	//����ĳһֵ�ýڵ�
	public BinaryNode<T> search(T x){
		return search(x, root);
	}
	
	//�Ƿ����һ��Ԫ��
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
	 * @param x Ҫ�Ƴ���Ԫ��
	 * @param root ������ �����ĸ�
	 * @return �Ƴ�Ҫ�Ƴ���Ԫ�غ�������ĸ��ڵ�
	 */
	private BinaryNode<T> remove(T x, BinaryNode<T> root) {
		//δ�ҵ�Ҫɾ���Ľڵ�
		if(root==null){
			return root;
		}
		//�����ж�Ҫɾ���Ľڵ���������������������
		int compareRes = x.compareTo(root.value);
		
		if(compareRes<0){
			//��������ɾ����������Ϊ����������
			root.lchild = remove(x,root.lchild);
		}else if(compareRes>0){
			//��������ɾ����������Ϊ����������
			root.rchild = remove(x,root.rchild);
		}else{
			//Ҫɾ����Ԫ�ؾ��Ǹ�Ԫ�أ�����Ҫ�жϣ���Ԫ���м�������
			//�������������
			if(root.lchild!=null&&root.rchild!=null){
				//������������С�Ľڵ�ֵ���滻���ڵ�ֵ
				root.value = findMin(root.rchild);
				//����������ɾ�������Сֵ����Ϊ��Сֵһ��û�����ӣ����Եݹ����removeʱ��һ����������ķ�֧
				root.rchild = remove(root.value, root.rchild);
			}else{
				//��������ӣ����Һ��ӣ����������滻�Լ������û�У������Һ����滻�Լ�����Ȼ�Һ���Ҳ����Ϊ�գ����൱���޺���ʱֻ���ý�root��Ϊnull
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
