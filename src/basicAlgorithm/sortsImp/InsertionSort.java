package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 * ≤Â»Î≈≈–Ú
 */
public class InsertionSort extends BaseSort implements SortInterface{

	/* (non-Javadoc)
	 * @see algoInteface.SortInterface#sortData()
	 * ≤Â»Î≈≈–Ú
	 */
	@Override
	public void sortData() {
		int[] _data = this.getDataToSort().clone();
		for(int i=1;i<_data.length;i++){
			int key = _data[i];
			int j = i;
			while(j>0&&key<_data[j-1]){
				_data[j] = _data[j-1];
				j--;
			}
			_data[j] = key;
		}
		this.setDataSorted(_data);
	}

	@Override
	public String printDataSorted() {
		return printData(this.getDataSorted());
	}

	@Override
	public String printDataToSort() {
		return printData(this.getDataToSort());
	}

}
