package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

public class Client {
	public static void main(String[] args) {
		int[] data = {31,41,59,26,41,58};
		SortInterface insertionSort = new InsertionSort();
		insertionSort.setDataToSort(data);
		insertionSort.sortData();
		System.out.println("********");
		System.out.println("≤Â»Î≈≈–Ú£∫");
		System.out.println("≈≈–Ú«∞£∫"+insertionSort.printDataToSort());
		System.out.println("≈≈–Ú∫Û£∫"+insertionSort.printDataSorted());
		
		System.out.println("********");
		SortInterface mergeSort = new MergeSort();
		mergeSort.setDataToSort(data);
		mergeSort.sortData();
		System.out.println("πÈ≤¢≈≈–Ú£∫");
		System.out.println("≈≈–Ú«∞£∫"+mergeSort.printDataToSort());
		System.out.println("≈≈–Ú∫Û£∫"+mergeSort.printDataSorted());
		
		System.out.println("********");
		SortInterface heapSort = new HeapSort();
		heapSort.setDataToSort(data);
		heapSort.sortData();
		System.out.println("∂—≈≈–Ú£∫");
		System.out.println("≈≈–Ú«∞£∫"+heapSort.printDataToSort());
		System.out.println("≈≈–Ú∫Û£∫"+heapSort.printDataSorted());
		
		System.out.println("********");
		SortInterface quickSort = new QuickSort();
		quickSort.setDataToSort(data);
		quickSort.sortData();
		System.out.println("øÏÀŸ≈≈–Ú£∫");
		System.out.println("≈≈–Ú«∞£∫"+quickSort.printDataToSort());
		System.out.println("≈≈–Ú∫Û£∫"+quickSort.printDataSorted());
		
		System.out.println("********");
		SortInterface countingSort = new CountingSort();
		countingSort.setDataToSort(data);
		countingSort.sortData();
		System.out.println("º∆ ˝≈≈–Ú£∫");
		System.out.println("≈≈–Ú«∞£∫"+countingSort.printDataToSort());
		System.out.println("≈≈–Ú∫Û£∫"+countingSort.printDataSorted());
		
		System.out.println("********");
		SortInterface selectSort = new SelectSort();
		selectSort.setDataToSort(data);
		selectSort.sortData();
		System.out.println("º∆ ˝≈≈–Ú£∫");
		System.out.println("≈≈–Ú«∞£∫"+selectSort.printDataToSort());
		System.out.println("≈≈–Ú∫Û£∫"+selectSort.printDataSorted());
	}

}
