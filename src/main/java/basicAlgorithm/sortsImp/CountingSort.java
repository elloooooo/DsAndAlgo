package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 * 计数排序
 * 
 * 没有利用数据之间的比较确定数据之间的位置关系，而是利用数组的固有顺序，对数据个数进行统计
 * 但是这样如果数据有负数则会出现问题，因为下标不会出现负数
 */
public class CountingSort extends BaseSort implements SortInterface {
	
	/**
	 * @param dataToSort 待排序数组
	 * @param dataSorted 已排序数组
	 * @param k 待排序数组中的最大值
	 */
	private void countingSort(int[] dataToSort,int[] dataSorted,int k){
		//保存待排序数据的计数量，每一项将会代表值为该下标的待排序项的计数，初始值都为0
		int[] tmp = new int[k+1];
		for(int i=0;i<tmp.length;i++){
			tmp[i] = 0;
		}
		//统计每一个值得个数，每一项代表待排序序列中下标所示值得个数
		for(int j=0;j<dataToSort.length;j++){
			tmp[dataToSort[j]] += 1; 
		}
		//每一项代表待排序序列中，下标所示值以及比该值小的数据的个数的和
		for(int i=1;i<=k;i++){
			tmp[i] = tmp[i-1]+tmp[i];
		}
		//根据统计数将值放进相应的输出位置
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
