package dsTest;

/**
 * @author Administrator
 * 01��������
 * 
 */
public class Package01 {

	public int getMaxValue(int[] v,int[] w,int W) {
		//dp[i][j]��ʾ����ǰi��Ԫ���У�ѡȡ������С�ڵ���j��Ԫ�ص���߼�ֵ
		int[][] dp = new int[v.length+1][W+1];
		for(int i=0;i<v.length;i++){
			for(int j=0;j<=W;j++){
				if(j<w[i]){
					//�����i+1��Ԫ�ص�����С��j
					dp[i+1][j] = dp[i][j];
				}else{
					//����
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
		//��Ʒ�ļ�ֵ
		int[] v = {3,2,4,2};
		//��Ʒ������
		int[] w = {2,1,3,2};
		//����������
		int W = 5;
		Package01 p = new Package01();
		int res = p.getMaxValue(v, w, W);
		System.out.println(res);
	}

}
