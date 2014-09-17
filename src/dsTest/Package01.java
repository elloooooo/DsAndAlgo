package dsTest;

/**
 * @author Administrator
 * 01背包问题
 * 
 */
public class Package01 {

	public int getMaxValue(int[] v,int[] w,int W) {
		//dp[i][j]表示，从前i个元素中，选取总重量小于等于j的元素的最高价值
		int[][] dp = new int[v.length+1][W+1];
		for(int i=0;i<v.length;i++){
			for(int j=0;j<=W;j++){
				if(j<w[i]){
					//如果第i+1个元素的重量小于j
					dp[i+1][j] = dp[i][j];
				}else{
					//否则
					dp[i+1][j] = max(dp[i][j],dp[i][j-w[i]]+v[i]);
				}
			}
		}
		return dp[v.length-1][W];
	}

	private int max(int i, int j) {
		return i>j?i:j;
	}

	public static void main(String[] args) {
		//物品的价值
		int[] v = {3,2,4,2};
		//物品的重量
		int[] w = {2,1,3,2};
		//背包的容量
		int W = 5;
		Package01 p = new Package01();
		int res = p.getMaxValue(v, w, W);
		System.out.println(res);
	}

}
