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
 * 动态规划思想，转化为求以某一个元素结尾的字串中，选择一个结尾元素与字串中元素的最大差值，
 * 
 * 知道以第[n-1]个元素为结尾的字串的最大差值后，就可以方便的求出以第[n]个元素结尾的字串的最大差值
 * 
 * 如果差值为负，就令其为0；
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
	 * 可以买卖多次，但是买之前一定要先卖出
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
