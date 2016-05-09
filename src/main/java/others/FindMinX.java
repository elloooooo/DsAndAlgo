package others;

/**
 * @author elloooooo
 * 找出输入序列中最小的k个
 * 利用获得顺序统计量的算法
 * 
 * 将数列按照最后一个元素划分，小于该项的放入第一个划分，大于的放入第二个划分
 * 如果划分元素等于k，则第一个划分为最小的k个，
 * 如果划分元素大于k，则在第一个划分中继续上述过程，
 * 如果划分元素小于k，则在第二个划分中继续上述过程。
 * 
 * 该算法期望时间复杂度为\Theta(n^2)
 */
public class FindMinX {
	private int[] data;
	
	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int parition(int[] data,int start,int end){
		int stand = data[end];
		int i = start-1;
		for(int j=start;j<end;j++){
			if(stand>data[j]){
				i++;
				int tmp = data[i];
				data[i] = data[j];
				data[j] = tmp ;
			}else{
				int tmp = data[j];
				data[j] = data[end];
				data[end] = tmp;
			}
		}
		return i+1;
	}
	
	public void findMinX(int start, int end, int k){
		if(start==end){
			printMinX(start);
		}else{
			int p = parition(data, start, end);
			if(p-start==k){
				printMinX(p);
			}else{
				if(k<p){
					findMinX(start,p-1,k);
				}else{
					findMinX(p,end,k-p);
				}

			}
		}
		
	}

	private void printMinX(int k) {
		for(int i=0;i<k;i++){
			System.out.println(data[i]);
		}
	}

	public static void main(String[] args) {
		int[] dataSet = {1,2,3,4,5,8,6,7};
		FindMinX findMinX = new FindMinX();
		findMinX.setData(dataSet);
		findMinX.findMinX(0, dataSet.length-1, 4);
	}

}
