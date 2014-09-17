package basicAlgorithm.sortsImp;

import basicAlgorithm.algoInteface.SortInterface;

public class Client {
	public static void main(String[] args) {
		int[] data = {31,41,59,26,41,58};
		SortInterface insertionSort = new InsertionSort();
		insertionSort.setDataToSort(data);
		insertionSort.sortData();
		System.out.println("********");
		System.out.println("��������");
		System.out.println("����ǰ��"+insertionSort.printDataToSort());
		System.out.println("�����"+insertionSort.printDataSorted());
		
		System.out.println("********");
		SortInterface mergeSort = new MergeSort();
		mergeSort.setDataToSort(data);
		mergeSort.sortData();
		System.out.println("�鲢����");
		System.out.println("����ǰ��"+mergeSort.printDataToSort());
		System.out.println("�����"+mergeSort.printDataSorted());
		
		System.out.println("********");
		SortInterface heapSort = new HeapSort();
		heapSort.setDataToSort(data);
		heapSort.sortData();
		System.out.println("������");
		System.out.println("����ǰ��"+heapSort.printDataToSort());
		System.out.println("�����"+heapSort.printDataSorted());
		
		System.out.println("********");
		SortInterface quickSort = new QuickSort();
		quickSort.setDataToSort(data);
		quickSort.sortData();
		System.out.println("��������");
		System.out.println("����ǰ��"+quickSort.printDataToSort());
		System.out.println("�����"+quickSort.printDataSorted());
		
		System.out.println("********");
		SortInterface countingSort = new CountingSort();
		countingSort.setDataToSort(data);
		countingSort.sortData();
		System.out.println("��������");
		System.out.println("����ǰ��"+countingSort.printDataToSort());
		System.out.println("�����"+countingSort.printDataSorted());
		
		System.out.println("********");
		SortInterface selectSort = new SelectSort();
		selectSort.setDataToSort(data);
		selectSort.sortData();
		System.out.println("��������");
		System.out.println("����ǰ��"+selectSort.printDataToSort());
		System.out.println("�����"+selectSort.printDataSorted());
	}

}
