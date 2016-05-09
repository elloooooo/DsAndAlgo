package dsTest;

/**
 * 剑指offer中在旋转数组中找最小值一题
 * 
 */
public class SearchMinInRotatedSortedArray {

	public static int getMin(int[] data){
		int begin = 0;
		int end = data.length-1;
		//将midIndex初始化为begin，因为如果数组是有序的，即将前0个元素移到后面，即数组是有序的，则应该直接返回第一元素
		int midIndex = begin;
		//begin将最终指向第一个递增序列的最后一个元素
		//end将最终指向第二个递增序列的第一个元素
		//第一个序列中的元素一定大于等于第二个序列中的元素
		while(data[begin]>=data[end]){
			//循环的最终，begin与end为相邻元素，end指向最小值
			if(begin+1==end){
				midIndex = end;
				break;
			}
			midIndex = (begin+end)/2;
			//如果begin，end，midIndex指向的元素大小相同，将无法确定，最小元素在哪一段中，所以此时只能顺序查找
			if(data[begin]==data[end]&&data[begin]==data[midIndex]){
				return getMinInorder(data,begin,end);
			}
			//如果mid元素大于begin，说明mid指向第一个序列中的元素，所以，最小值一定在后一段
			if(data[midIndex]>=data[begin]){
				begin = midIndex;
			}else if(data[midIndex]<=data[end]){
				//mid小于end，说明mid指向第二个序列中元素，所以，最小值在前一段
				end = midIndex;
			}
		}
		return data[midIndex];
	}
	private static int getMinInorder(int[] data, int begin, int end) {
		int res = data[begin];
		while(end>=begin){
			res = res>data[begin]?data[begin]:res;
			begin++;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] data = {4,5,1,2,3};
		int min = SearchMinInRotatedSortedArray.getMin(data);
		System.out.println(min);
	}

}
