package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 * ��������
 * 
 * û����������֮��ıȽ�ȷ������֮���λ�ù�ϵ��������������Ĺ���˳�򣬶����ݸ�������ͳ��
 * ����������������и������������⣬��Ϊ�±겻����ָ���
 */
public class CountingSort extends BaseSort implements SortInterface {
	
	/**
	 * @param dataToSort ����������
	 * @param dataSorted ����������
	 * @param k �����������е����ֵ
	 */
	private void countingSort(int[] dataToSort,int[] dataSorted,int k){
		//������������ݵļ�������ÿһ������ֵΪ���±�Ĵ�������ļ�������ʼֵ��Ϊ0
		int[] tmp = new int[k+1];
		for(int i=0;i<tmp.length;i++){
			tmp[i] = 0;
		}
		//ͳ��ÿһ��ֵ�ø�����ÿһ�����������������±���ʾֵ�ø���
		for(int j=0;j<dataToSort.length;j++){
			tmp[dataToSort[j]] += 1; 
		}
		//ÿһ���������������У��±���ʾֵ�Լ��ȸ�ֵС�����ݵĸ����ĺ�
		for(int i=1;i<=k;i++){
			tmp[i] = tmp[i-1]+tmp[i];
		}
		//����ͳ������ֵ�Ž���Ӧ�����λ��
		for(int j=dataToSort.length-1;j>=0;j--){
			dataSorted[tmp[dataToSort[j]]-1] = dataToSort[j];
			tmp[dataToSort[j]]--;
		}
	}
	@Override
	public void sortData() {
		int maxValue = this.getMaxValue(this.getDataToSort());
		int[] dataSorted = new int[this.getDataToSort().length];
		this.countingSort(this.getDataToSort(),dataSorted,maxValue);
		this.setDataSorted(dataSorted);
	}

	private int getMaxValue(int[] data) {
		int _max = -9999;
		for(int i=0;i<data.length;i++){
			if(_max<data[i]){
				_max=data[i];
			}
		}
		return _max;
	}
	@Override
	public String printDataSorted() {
		return printData(this.getDataSorted());
	}

	@Override
	public String printDataToSort() {
		return printData(this.getDataToSort());
	}
	public static void main(String[] args) {
		int[] test = {2,4,5,5};
		int[] res = new int[4];
		CountingSort countingSort = new CountingSort();
		countingSort.countingSort(test, res,5);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
}
