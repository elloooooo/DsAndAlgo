package dsTest;

import java.util.Arrays;
import java.util.Comparator;


class Cmp implements Comparator<String>{
	
	@Override
	public int compare(String o1, String o2) {
		int i=0;
		while(i<=min(o1.length(),o2.length())){
			if(o1.charAt(i)<o2.charAt(i)){
				return -1;
			}else if(o1.charAt(i)>o2.charAt(i)){
				return 1;
			}else{
				if(o1.length()<o2.length()){
					return -1;
				}else if(o1.length()>o2.length()){
					return 1;
				}
			}
			i++;
		}
		return 0;
	}

	private int min(int a, int b) {
		return a<b?a:b;
	}
	
}

/**
 * 给定一个数组，将里面的数字排序，使得排好序的数组形成的数字最小
 *
 */
public class SortArrayToBuildMinNum {
	public void sort(int[] data){
		String[] str = new String[data.length];
		for(int i=0;i<data.length;i++){
			str[i] = Integer.valueOf(data[i]).toString();
		}
		Comparator<String> cmp = new Cmp();
		Arrays.sort(str, cmp);
		for(int i=0;i<data.length;i++){
			data[i] = Integer.parseInt(str[i]);
		}
	}
	public static void main(String[] args) {
		int[] data = {3,83,8,1,13};
		SortArrayToBuildMinNum s = new SortArrayToBuildMinNum();
		s.sort(data);
		for(int elem :data){
			System.out.println(elem);
		}
	}

}
