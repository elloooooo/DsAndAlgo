package basicAlgorithm.sortsImp;
import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 * 快速排序
 */
public class QuickSort extends BaseSort implements SortInterface {

	/**
	 * 将待排序数组分为两段,前一段所有元素都小于分割处的元素，而后半段都大于分割处的元素
	 * @param data 待分组数据
	 * @param p 起始下标
	 * @param r 结束下标
	 * @return 返回分组元素下标
	 */
	private int partition(int[] data,int p, int r){
		//将最后一个元素当作分割元素
		int x = data[r];
		//i指向小于分割元素队列的新近元素
		int i = p-1;
		for(int j=p;j<r;j++){
			if(data[j]<=x){
				i++;
				int tmp = data[j];
				data[j] = data[i];
				data[i] = tmp;
			}else{
				int tmp = data[j];
				data[j] = data[r];
				data[r] = tmp;
			}
		}
		return i+1;
	}
	
	/**
	 * @param data 待分组数据
	 * @param p 起始下标
	 * @param r 结束下标
	 */
	private void quickSort(int[] data,int p, int r){
		if(p<r){
			int q = this.partition(data, p, r);
			this.quickSort(data,p,q-1);
			this.quickSort(data,q,r);
		}
	}
	
	@Override
	public void sortData() {
		int[] _data = this.getDataToSort().clone();
		this.quickSort(_data,0,_data.length-1);
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
