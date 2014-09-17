package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo 归并排序
 */
public class MergeSort extends BaseSort implements SortInterface {
	private static final int MAX_VALUE = 2147483647;

	/**
	 * p,q,r为数组下标，满足p<q<r 将数组data拆分为一个有q-p+1个元素和一个有r-q个元素的两个数组， 并将这两个已经排好顺序的数组合并
	 */
	private void merge(int[] data, int p, int q, int r) {
		// 根据传入的下标获得左右数组的长度
		int l_length = q - p + 1;
		int r_length = r - q;
		// 新建左右数据，为最后一个哨兵数预留一个数组元素
		int[] L = new int[l_length + 1];
		int[] R = new int[r_length + 1];
		// 将data的值存入左右数组，并在最后增加哨兵数
		for (int i = 0; i < l_length; i++) {
			L[i] = data[p + i];
		}
		L[l_length] = MAX_VALUE;
		for (int j = 0; j < r_length; j++) {
			R[j] = data[q + j + 1];
		}
		R[r_length] = MAX_VALUE;
		// 合并左右数组
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
	 * 对数组data[p]~data[r]进行排序
	 * 
	 * @param data 要排序的数组
	 * @param p	要排序数组，起始元素的下标
	 * @param r 要排序数组，结束元素的下标
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
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] data2 = { 2, 1, 5, 4, 15, 10, 12 ,13,3};
		mergeSort.sortData(data2, 0, 8);
		System.out.println("end");
	}
}
