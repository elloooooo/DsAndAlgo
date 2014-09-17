package basicAlgorithm.sortsImp;

import util.SortUtil;
import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 * ѡ���������ñ���i��¼�Ѿ������Ԫ�ص����һ�������ϴ�Ϊ����Ĳ�����ѡ����Сֵ����i�ཻ��
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
