package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 *	������
 */
public class HeapSort extends BaseSort implements SortInterface {
	private int heapSize;
	/**
	 * ��ø����±�Ԫ�صĸ�Ԫ�ص��±�
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unused")
	private int parent(int i){
		return i/2;
	}
	/**
	 * ��ø����±�Ԫ�����ӵ��±�
	 * @param i
	 * @return
	 */
	private int left(int i){
		return i*2;
	}
	/**
	 * ��ø����±�Ԫ���Һ��ӵ��±�
	 * @param i
	 * @return
	 */
	private int right(int i){
		return i*2+1;
	}
	
	/**
	 * ά����������data���±�Ϊindex���µ���������
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
	 * ��һ�����鹹��Ϊ����
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
			//���ѵĸ��ڵ�data[0]�����һ��Ԫ�ػ�������������������Ԫ�ط���������ĩβ
			int tmp = _data[i];
			_data[i] = _data[0];
			_data[0] = tmp;
			//�����һ��Ԫ�شӶ���ȥ��
			this.heapSize--;
			//����ά�����ѵ�����
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
