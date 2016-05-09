package dsTest;

/**
 * @author elloooooo
 * 检测一个序列是否是二叉搜索树的后续遍历结果
 * 
 * 递归的获得每一个节点的左子树（小于根节点的元素），检查剩下的元素是否都是大于根节点，由此判断是否满足二叉搜索树的性质
 */
public class IsBSTPostorderWalk {
	private int[] dataSet;
	public int[] getDataSet() {
		return dataSet;
	}

	public void setDataSet(int[] dataSet) {
		this.dataSet = dataSet;
	}
	//flag 用于保存检测结果
	private boolean flag=true;
	public void isBSTPW(int[] data,int startIndex,int rootIndex,boolean flag){
		//flag代表父节点对左右子树特性的判断结果，只有父节点判断特性成立，继续判断才有意义
		if(flag&&startIndex<rootIndex){
			int left = startIndex;
			//left-1表示根节点的左子树的下标
			while(data[left]<data[rootIndex]){
				left++;
			}
			//从left下标开始，之后的都应该属于根节点的右子树，判断特性是否成立
			for(int j = left;j<rootIndex;j++){
				if(data[j]<data[rootIndex]){
					this.flag = false;
				}
			}
			//检测数据左子树的左右子树
			isBSTPW(data,0,left-1,this.flag);
			//检测右子数的左右子树
			isBSTPW(data,left,rootIndex-1,this.flag);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a= {5,7,6,9,11,10,8};
		int[] b = {7,4,6,5};
		IsBSTPostorderWalk s = new IsBSTPostorderWalk();
		s.isBSTPW(a, 0, a.length-1, s.flag);
		System.out.println(s.flag);

	}

}
