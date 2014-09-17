package dsTest;



/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 */
public class Candy {
	public int candy(int[] ratings) {
		//从左向右遍历，只要后一个元素比前一个大，则糖果数+1，否则，糖果数为1
		int[] ltra =  new int[ratings.length];
		ltra[0] = 1;
		for(int i=1;i<ratings.length;i++){
			if(ratings[i]>ratings[i-1]){
				ltra[i] = ltra[i-1]+1;
			}else{
				ltra[i] = 1;
			}
		}
		//从右向左遍历，只要前一个元素比后一个大，糖果数+1，否则为1
		int[] rtra =  new int[ratings.length];
		rtra[ratings.length-1] = 1;
		for(int i=ratings.length-2;i>=0;i--){
			if(ratings[i]>ratings[i+1]){
				rtra[i] = rtra[i+1]+1;
			}else{
				rtra[i] = 1;
			}
		}
		//第一次遍历结果保证所有分高的孩子比他左侧的孩子糖果多
		//第二次遍历保证分高的孩子比他右侧的孩子糖果多
		//将两次结果每个点的糖果数取较大值，就是满足条件两侧的条件
		int[] res = new int[ratings.length];
		for(int i=0;i<ratings.length;i++){
			if(ltra[i]>rtra[i]){
				res[i] = ltra[i];
			}else{
				res[i] = rtra[i];
			}
		}
		int min = 0;
		for(int i=0;i<res.length;i++){
			min+=res[i];
		}
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] rate = {1,2,2};
		Candy c = new Candy();
		int min = c.candy(rate);
		System.out.println(min);
	}

}
