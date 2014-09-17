package basicAlgorithm.sortsImp;
import basicAlgorithm.algoInteface.SortInterface;

/**
 * @author elloooooo
 * ��������
 */
public class QuickSort extends BaseSort implements SortInterface {

	/**
	 * �������������Ϊ����,ǰһ������Ԫ�ض�С�ڷָ��Ԫ�أ������ζ����ڷָ��Ԫ��
	 * @param data ����������
	 * @param p ��ʼ�±�
	 * @param r �����±�
	 * @return ���ط���Ԫ���±�
	 */
	private int partition(int[] data,int p, int r){
		//�����һ��Ԫ�ص����ָ�Ԫ��
		int x = data[r];
		//iָ��С�ڷָ�Ԫ�ض��е��½�Ԫ��
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
	 * @param data ����������
	 * @param p ��ʼ�±�
	 * @param r �����±�
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
