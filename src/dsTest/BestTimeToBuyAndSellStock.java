package dsTest;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 */

/**
 * @author Administrator
 * Answer:
 * ��̬�滮˼�룬ת��Ϊ����ĳһ��Ԫ�ؽ�β���ִ��У�ѡ��һ����βԪ�����ִ���Ԫ�ص�����ֵ��
 * 
 * ֪���Ե�[n-1]��Ԫ��Ϊ��β���ִ�������ֵ�󣬾Ϳ��Է��������Ե�[n]��Ԫ�ؽ�β���ִ�������ֵ
 * 
 * �����ֵΪ����������Ϊ0��
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if(prices.length==0||prices.length==1){
			return 0;
		}
		
		int[] maxDiff = new int[prices.length];
		maxDiff[0] = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			maxDiff[i] = maxDiff[i-1]+prices[i] - prices[i - 1];
			if(maxDiff[i]<0){
				maxDiff[i] = 0;
			}
			max = maxDiff[i]>max?maxDiff[i]:max;
		}
		return max;
	}
	
	/**
	 * ����������Σ�������֮ǰһ��Ҫ������
	 * @param prices
	 * @return
	 */
	public int maxProfitII(int[] prices) {
		if(prices.length==0||prices.length==1){
			return 0;
		}
		int sum = 0;
		
		for(int i=0;i<prices.length-1;){
			int j = i;
			while(j+1<prices.length&&prices[j+1]>prices[j]){
					j++;
			}
			sum += prices[j] - prices[i];
			i = j+1;
		}
		
		
		return sum;
	}

	public static void main(String[] args) {
		int[] prices = {2,1,4};
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		int max = b.maxProfit(prices);
		int sum = b.maxProfitII(prices);
		System.out.println(sum);

	}

}
