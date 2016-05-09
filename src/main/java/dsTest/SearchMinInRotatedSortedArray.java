package dsTest;

/**
 * ��ָoffer������ת����������Сֵһ��
 * 
 */
public class SearchMinInRotatedSortedArray {

	public static int getMin(int[] data){
		int begin = 0;
		int end = data.length-1;
		//��midIndex��ʼ��Ϊbegin����Ϊ�������������ģ�����ǰ0��Ԫ���Ƶ����棬������������ģ���Ӧ��ֱ�ӷ��ص�һԪ��
		int midIndex = begin;
		//begin������ָ���һ���������е����һ��Ԫ��
		//end������ָ��ڶ����������еĵ�һ��Ԫ��
		//��һ�������е�Ԫ��һ�����ڵ��ڵڶ��������е�Ԫ��
		while(data[begin]>=data[end]){
			//ѭ�������գ�begin��endΪ����Ԫ�أ�endָ����Сֵ
			if(begin+1==end){
				midIndex = end;
				break;
			}
			midIndex = (begin+end)/2;
			//���begin��end��midIndexָ���Ԫ�ش�С��ͬ�����޷�ȷ������СԪ������һ���У����Դ�ʱֻ��˳�����
			if(data[begin]==data[end]&&data[begin]==data[midIndex]){
				return getMinInorder(data,begin,end);
			}
			//���midԪ�ش���begin��˵��midָ���һ�������е�Ԫ�أ����ԣ���Сֵһ���ں�һ��
			if(data[midIndex]>=data[begin]){
				begin = midIndex;
			}else if(data[midIndex]<=data[end]){
				//midС��end��˵��midָ��ڶ���������Ԫ�أ����ԣ���Сֵ��ǰһ��
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
