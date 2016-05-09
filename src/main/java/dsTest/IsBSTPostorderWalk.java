package dsTest;

/**
 * @author elloooooo
 * ���һ�������Ƿ��Ƕ����������ĺ����������
 * 
 * �ݹ�Ļ��ÿһ���ڵ����������С�ڸ��ڵ��Ԫ�أ������ʣ�µ�Ԫ���Ƿ��Ǵ��ڸ��ڵ㣬�ɴ��ж��Ƿ��������������������
 */
public class IsBSTPostorderWalk {
	private int[] dataSet;
	public int[] getDataSet() {
		return dataSet;
	}

	public void setDataSet(int[] dataSet) {
		this.dataSet = dataSet;
	}
	//flag ���ڱ�������
	private boolean flag=true;
	public void isBSTPW(int[] data,int startIndex,int rootIndex,boolean flag){
		//flag�����ڵ�������������Ե��жϽ����ֻ�и��ڵ��ж����Գ����������жϲ�������
		if(flag&&startIndex<rootIndex){
			int left = startIndex;
			//left-1��ʾ���ڵ�����������±�
			while(data[left]<data[rootIndex]){
				left++;
			}
			//��left�±꿪ʼ��֮��Ķ�Ӧ�����ڸ��ڵ�����������ж������Ƿ����
			for(int j = left;j<rootIndex;j++){
				if(data[j]<data[rootIndex]){
					this.flag = false;
				}
			}
			//�����������������������
			isBSTPW(data,0,left-1,this.flag);
			//�������������������
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
