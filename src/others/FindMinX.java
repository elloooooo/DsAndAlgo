package others;

/**
 * @author elloooooo
 * �ҳ�������������С��k��
 * ���û��˳��ͳ�������㷨
 * 
 * �����а������һ��Ԫ�ػ��֣�С�ڸ���ķ����һ�����֣����ڵķ���ڶ�������
 * �������Ԫ�ص���k�����һ������Ϊ��С��k����
 * �������Ԫ�ش���k�����ڵ�һ�������м����������̣�
 * �������Ԫ��С��k�����ڵڶ��������м����������̡�
 * 
 * ���㷨����ʱ�临�Ӷ�Ϊ\Theta(n^2)
 */
public class FindMinX {
	private int[] data;
	
	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int parition(int[] data,int start,int end){
		int stand = data[end];
		int i = start-1;
		for(int j=start;j<end;j++){
			if(stand>data[j]){
				i++;
				int tmp = data[i];
				data[i] = data[j];
				data[j] = tmp ;
			}else{
				int tmp = data[j];
				data[j] = data[end];
				data[end] = tmp;
			}
		}
		return i+1;
	}
	
	public void findMinX(int start, int end, int k){
		if(start==end){
			printMinX(start);
		}else{
			int p = parition(data, start, end);
			if(p-start==k){
				printMinX(p);
			}else{
				if(k<p){
					findMinX(start,p-1,k);
				}else{
					findMinX(p,end,k-p);
				}

			}
		}
		
	}

	private void printMinX(int k) {
		for(int i=0;i<k;i++){
			System.out.println(data[i]);
		}
	}

	public static void main(String[] args) {
		int[] dataSet = {1,2,3,4,5,8,6,7};
		FindMinX findMinX = new FindMinX();
		findMinX.setData(dataSet);
		findMinX.findMinX(0, dataSet.length-1, 4);
	}

}
