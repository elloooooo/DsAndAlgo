package basicAlgorithm.selectImp;

import basicAlgorithm.algoInteface.SelectInterface;

/**
 * @author elloooooo
 * 获得最大值或者最小值
 */
public class MaxOrMin implements SelectInterface{
	private int[] data;
	private int selectedData;
	
	
	public int getSelectedData() {
		return selectedData;
	}

	public void setSelectedData(int selectedData) {
		this.selectedData = selectedData;
	}

	@Override
	public void setData(int[] dataSet) {
		this.data = dataSet;
	}

	@Override
	public void printSelectedDate() {
		System.out.println("选出的数据："+ this.selectedData);
	}
	
	public void getMax(){
		this.selectedData = 0;
		for(int i=0;i<this.data.length;i++){
			if(this.data[i]>this.selectedData){
				this.selectedData = this.data[i];
			}
		}
	}
	
	public void getMin(){
		this.selectedData=9999;
		for(int i=0;i<this.data.length;i++){
			if(this.data[i]<this.selectedData){
				this.selectedData = this.data[i];
			}
		}
	}
	
	

}
