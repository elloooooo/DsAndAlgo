package dsTest;

/**
 * @author Administrator
 * ¶ş·Ö²éÕÒ
 */
public class BinarySearch {
	
	public int find(int[] data,int target) {
		int begin = 0,end= data.length-1;
		while(begin<=end){
			int i = (begin+end)/2;
			
			if(target == data[i]){
				return i;
			}else if(target<data[i]){
				end = i-1;
			}else{
				begin = i+1;
			}
		}
		
		return -1;
	}

}
