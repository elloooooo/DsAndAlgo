package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 *	堆排序
 */
public class HeapSort extends BaseSort implements SortInterface {
	private int heapSize;
	/**
	 * 获得给定下标元素的父元素的下标
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unused")
	private int parent(int i){
		return i/2;
	}
	/**
	 * 获得给点下标元素左孩子的下标
	 * @param i
	 * @return
	 */
	private int left(int i){
		return i*2;
	}
	/**
	 * 获得给定下标元素右孩子的下标
	 * @param i
	 * @return
	 */
	private int right(int i){
		return i*2+1;
	}
	
	/**
	 * 维护给定数组data中下标为index以下的最大堆性质
	 * @param data
	 * @param index
	 */
	private void maxHeapify(int[] data, int index){
		int l = this.left(index);
		int r = this.right(index);
		int largest = index;
		if(l<this.heapSize&&data[l]>data[index]){
			largest = l;
		}
		if(r<this.heapSize&&data[r]>data[largest]){
			largest = r;
		}
		if(largest!=index){
			int tmp = data[index];
			data[index] = data[largest];
			data[largest] = tmp;
			this.maxHeapify(data, largest);
		}
	}
	
	/**
	 * 将一个数组构建为最大堆
	 * @param data
	 */
	private void buildMaxHeap(int[] data){
		this.heapSize = data.length;
		for(int i=this.heapSize/2;i>=0;i--){
			this.maxHeapify(data, i);
		}
	}
	
	@Override
	public void sortData() {
		int[] _data = this.getDataToSort().clone();
		this.buildMaxHeap(_data);
		for(int i=_data.length-1;i>1;i--){
			//将堆的根节点data[0]与最后一个元素互换，即将数组中最大的元素放置在数组末尾
			int tmp = _data[i];
			_data[i] = _data[0];
			_data[0] = tmp;
			//将最后一个元素从堆中去除
			this.heapSize--;
			//重新维护最大堆的性质
			this.maxHeapify(_data, 0);
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
