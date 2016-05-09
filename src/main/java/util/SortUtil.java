package util;

public class SortUtil {
	/**
	 * �ж��Ƿ� v>w
	 * @param v
	 * @param w
	 * @return
	 */
	public static boolean  less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	/**
	 * ��������������Ԫ�ص�ֵ
	 * @param dataSet
	 * @param i
	 * @param j
	 */
	public static void exch(@SuppressWarnings("rawtypes") Comparable[] dataSet,int i,int j){
		Comparable<?> swap = dataSet[i];
		dataSet[i] = dataSet[j];
		dataSet[j] = swap;
	}
	/**
	 * �������������е�����Ԫ��
	 * @param dataSet
	 * @param i
	 * @param j
	 */
	public static void exch(int[] dataSet, int i, int j) {
		int swap = dataSet[i];
		dataSet[i] = dataSet[j];
		dataSet[j] = swap;
	}
	/**
	 * �ж����ݼ��Ƿ��Ѿ�����
	 * @param dataSet
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] dataSet){
		for(int i=1;i<dataSet.length;i++){
			if(dataSet[i].compareTo(dataSet[i-1])<0){
				return false;
			}
		}
		return true;
	}
	
	
}
