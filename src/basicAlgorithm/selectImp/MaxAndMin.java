package basicAlgorithm.selectImp;

import basicAlgorithm.algoInteface.SelectInterface;

/**
 * @author elloooooo ͬʱ��������Сֵ�����Լ��ٽ��Ƚϴ������ٵ�3n/2
 * 
 */
public class MaxAndMin implements SelectInterface {
	private int max;
	private int min;
	private int[] data;

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public void setData(int[] dataSet) {
		this.data = dataSet;
	}

	@Override
	public void printSelectedDate() {
		System.out.println("���ֵ��" + this.max);
		System.out.println("��Сֵ��" + this.min);
	}

	public void getMaxAndMin() {
		// �ȽϿ�ʼʱ��Index
		int sIndex = 0;
		// ��ʼ�������Сֵ
		switch (this.data.length % 2) {
		case 0:// ����Ϊż��
			if (this.data[0] > this.data[1]) {
				this.max = this.data[0];
				this.min = this.data[1];
			} else {
				this.max = this.data[1];
				this.min = this.data[0];
			}
			sIndex = 2;// ���±�2��ʼ
			break;
		case 1:// ����Ϊ����
			this.max = this.data[0];
			this.min = this.data[0];
			sIndex = 1;// ���±�1��ʼ
			break;
		default:
			break;
		}
		// ÿ��������Ҫ���αȽ�
		for (int j = sIndex; j < this.data.length; j += 2) {
			if (this.data[j] < this.data[j + 1]) {
				if (this.data[j] < this.min) {
					this.min = this.data[j];
				}
				if (this.data[j + 1] > this.max) {
					this.max = this.data[j + 1];
				}
			} else {
				if (this.data[j + 1] < this.min) {
					this.min = this.data[j + 1];
				}
				if (this.data[j] > this.max) {
					this.max = this.data[j];
				}
			}
		}
	}

}
