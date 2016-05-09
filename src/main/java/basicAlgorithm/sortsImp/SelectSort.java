package basicAlgorithm.sortsImp;

import util.SortUtil;
import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 * 选择排序，利用变量i记录已经排序的元素的最后一个，不断从为排序的部分中选择最小值，与i相交换
 *
 */
public class SelectSort extends BaseSort implements SortInterface {

	@Override
	public void sortData() {
		int[] dataSet = this.getDataToSort().clone();
		int i = 0;
		while(i<dataSet.length){
			int minIndex = 0;
			int min = 9999;
			for(int j=i;j<dataSet.length;j++){
				if(SortUtil.less(dataSet[j], min)){
					minIndex = j;
					min = dataSet[j];
				}
			}
			SortUtil.exch(dataSet, i, minIndex);
			i++;
		}
		this.setDataSorted(dataSet);
	}

	@Override
	public String printDataSorted() {
		return this.printData(this.getDataSorted());
	}

	@Override
	public String printDataToSort() {
		return this.printData(this.getDataToSort());
	}


}
