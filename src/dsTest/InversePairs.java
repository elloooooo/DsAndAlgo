package dsTest;

/**
 * 剑指offer
 * 
 * 输入一个数组，求出数组中逆序对的个数
 * 
 */
public class InversePairs {

	public int inversePairs(int[] data){
		if(data == null||data.length==0){
			return 0; 
		}
		int[] copy = new int[data.length];
		for(int i=0;i<data.length;i++){
			copy[i] = data[i];
		}
		return countPairs(data,copy,0,data.length-1);
	}
	
	private int countPairs(int[] data,int[] copy,int begin,int end){
		if(begin==end){
			return 0;
		}
		//将数组一分为二
		int length = (end-begin)/2;
		//统计左半部分逆序对数量
		int left = countPairs(copy,data,begin,begin+length);
		//统计右半部份逆序对数量
		int right = countPairs(copy,data,begin+length+1,end);
		
		//统计跨两部分的逆序对数量，并将左右两部分元素排序，置入copy中
		int i = begin+length;
		int j = end;
		int count = 0;
		int copyIndex = end;
		while(i>=begin&&j>=begin+length){
			if(data[i]>data[j]){
				copy[copyIndex--] = data[i--];
				count += j-begin-length;  
			}else{
				copy[copyIndex--] = data[j--];
			}
		}
		for(;i>begin;--i){
			copy[copyIndex--] = data[i];
		}
		for(;j>begin+length;--j){
			copy[copyIndex--] = data[j];
		}
		return left+right+count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data= {7,5,6,4};
		InversePairs i = new InversePairs();
		int res = i.inversePairs(data);
		System.out.println(res);
	}

}
