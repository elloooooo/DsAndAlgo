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
		//�������ұ�����ֻҪ��һ��Ԫ�ر�ǰһ�������ǹ���+1�������ǹ���Ϊ1
		int[] ltra =  new int[ratings.length];
		ltra[0] = 1;
		for(int i=1;i<ratings.length;i++){
			if(ratings[i]>ratings[i-1]){
				ltra[i] = ltra[i-1]+1;
			}else{
				ltra[i] = 1;
			}
		}
		//�������������ֻҪǰһ��Ԫ�رȺ�һ�����ǹ���+1������Ϊ1
		int[] rtra =  new int[ratings.length];
		rtra[ratings.length-1] = 1;
		for(int i=ratings.length-2;i>=0;i--){
			if(ratings[i]>ratings[i+1]){
				rtra[i] = rtra[i+1]+1;
			}else{
				rtra[i] = 1;
			}
		}
		//��һ�α��������֤���зָߵĺ��ӱ������ĺ����ǹ���
		//�ڶ��α�����֤�ָߵĺ��ӱ����Ҳ�ĺ����ǹ���
		//�����ν��ÿ������ǹ���ȡ�ϴ�ֵ�����������������������
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
