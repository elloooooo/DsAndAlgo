package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo �鲢����
 */
public class MergeSort extends BaseSort implements SortInterface {
	private static final int MAX_VALUE = 2147483647;

	/**
	 * p,q,rΪ�����±꣬����p<q<r ������data���Ϊһ����q-p+1��Ԫ�غ�һ����r-q��Ԫ�ص��������飬 �����������Ѿ��ź�˳�������ϲ�
	 */
	private void merge(int[] data, int p, int q, int r) {
		// ���ݴ�����±�����������ĳ���
		int l_length = q - p + 1;
		int r_length = r - q;
		// �½��������ݣ�Ϊ���һ���ڱ���Ԥ��һ������Ԫ��
		int[] L = new int[l_length + 1];
		int[] R = new int[r_length + 1];
		// ��data��ֵ�����������飬������������ڱ���
		for (int i = 0; i < l_length; i++) {
			L[i] = data[p + i];
		}
		L[l_length] = MAX_VALUE;
		for (int j = 0; j < r_length; j++) {
			R[j] = data[q + j + 1];
		}
		R[r_length] = MAX_VALUE;
		// �ϲ���������
		int l_index = 0;
		int r_index = 0;
		for (int k = p; k <= r; k++) {
			if (L[l_index] < R[r_index]) {
				data[k] = L[l_index];
				l_index++;
			} else {
				data[k] = R[r_index];
				r_index++;
			}
		}
	}
	
	/**
	 * ������data[p]~data[r]��������
	 * 
	 * @param data Ҫ���������
	 * @param p	Ҫ�������飬��ʼԪ�ص��±�
	 * @param r Ҫ�������飬����Ԫ�ص��±�
	 */
	private void sortData(int[] data, int p, int r) {
		if(p<r){
			int q = (p+r)/2;
			this.sortData(data, p, q);
			this.sortData(data, q+1, r);
			this.merge(data, p, q, r);
		}
	}

	@Override
	public void sortData() {
		int[] _data = this.getDataToSort().clone();
		int start_index = 0;
		int end_index = _data.length-1;
		this.sortData(_data, start_index, end_index);
		this.setDataSorted(_data);
	}

	@Override
	public String printDataSorted() {
		return this.printData(this.getDataSorted());
	}

	@Override
	public String printDataToSort() {
		return this.printData(this.getDataToSort());
	}
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] data2 = { 2, 1, 5, 4, 15, 10, 12 ,13,3};
		mergeSort.sortData(data2, 0, 8);
		System.out.println("end");
	}
}
