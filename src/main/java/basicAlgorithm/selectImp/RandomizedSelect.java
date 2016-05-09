package basicAlgorithm.selectImp;

import basicAlgorithm.algoInteface.SelectInterface;

public class RandomizedSelect implements SelectInterface {
	private int[] data;
	private int selected;

	@Override
	public void setData(int[] dataSet) {
		this.data = dataSet.clone();
	}

	@Override
	public void printSelectedDate() {
		System.out.println("ѡ����Ԫ�أ�" + this.selected);
	}

	/**
	 * @param data ����������
	 * @param p ��ʼ�±�
	 * @param r �����±�
	 * @return ����Ԫ�ص��±꣨����Ԫ�ؽ���Ϊ���ֺ�벿�ֵĵ�һ��Ԫ�أ�
	 */
	private int parition(int[] data, int p, int r) {
		int x = data[r];
		int i = p - 1;
		for (int j = p; j < r - p + 1; j++) {
			if (data[j] < x) {
				i++;
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			} else {
				int temp = data[r];
				data[r] = data[j];
				data[j] = temp;
			}
		}
		return i + 1;
	}

	public void randomizedSelect(int p, int r, int rank) {
		if (p == r) {
			this.selected = data[p];
		} else {
			int q = this.parition(this.data, p, r);
			if (rank == q - p+ 1) {
				this.selected = data[q];
			} else {
				if (rank < q + 1) {
					//���Ҫ�������ڻ���Ԫ��֮ǰ�����ڻ��ֵ�ǰ�벿�ֻ��ֲ���
					randomizedSelect(p, q - 1, rank);
				} else {
					//�����ں�벿�ּ�������
					randomizedSelect(q, r, rank - q );
				}
			}
		}
	}
}
