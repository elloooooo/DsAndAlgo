package basicAlgorithm.selectImp;

import basicAlgorithm.algoInteface.SelectInterface;

/**
 * @author elloooooo 同时获得最大最小值，可以减少将比较次数减少到3n/2
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
		System.out.println("最大值：" + this.max);
		System.out.println("最小值：" + this.min);
	}

	public void getMaxAndMin() {
		// 比较开始时的Index
		int sIndex = 0;
		// 初始化最大最小值
		switch (this.data.length % 2) {
		case 0:// 数列为偶数
			if (this.data[0] > this.data[1]) {
				this.max = this.data[0];
				this.min = this.data[1];
			} else {
				this.max = this.data[1];
				this.min = this.data[0];
			}
			sIndex = 2;// 从下标2开始
			break;
		case 1:// 数列为奇数
			this.max = this.data[0];
			this.min = this.data[0];
			sIndex = 1;// 从下标1开始
			break;
		default:
			break;
		}
		// 每对数字需要三次比较
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
