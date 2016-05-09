package basicAlgorithm.algoInteface;

public interface SortInterface {
	public int[] getDataToSort();
	public void setDataToSort(int[] dataToSort);
	public int[] getDataSorted() ;
	public void setDataSorted(int[] dataSorted);
	public void sortData();
	public String printDataSorted();
	public String printDataToSort();
}
