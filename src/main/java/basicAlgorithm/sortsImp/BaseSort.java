package basicAlgorithm.sortsImp;

public class BaseSort {
	private int[] dataToSort;

	private int[] dataSorted;
	
	public int[] getDataToSort() {
		return dataToSort;
	}

	public void setDataToSort(int[] dataToSort) {
		this.dataToSort = dataToSort;
	}

	public int[] getDataSorted() {
		return dataSorted;
	}

	public void setDataSorted(int[] dataSorted) {
		this.dataSorted = dataSorted;
	}
	
	public String printData(int[] data){
		StringBuffer res = new StringBuffer();
		for(int i=0;i<data.length;i++){
			res.append(data[i]+",");
		}
		res.deleteCharAt(res.toString().length()-1);
		return res.toString();
	}
	

}
