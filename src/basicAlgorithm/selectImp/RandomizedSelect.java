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
		System.out.println("选出的元素：" + this.selected);
	}

	/**
	 * @param data 待划分数组
	 * @param p 起始下标
	 * @param r 结束下标
	 * @return 划分元素的下标（划分元素将作为划分后半部分的第一个元素）
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
					//如果要求的序号在划分元素之前，则在划分的前半部分划分查找
					randomizedSelect(p, q - 1, rank);
				} else {
					//否则在后半部分继续划分
					randomizedSelect(q, r, rank - q );
				}
			}
		}
	}
}
