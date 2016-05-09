package dsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
public class Triangle {
	//法一：利用dfs超时了
	private int minPath;
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size()==0){
			return 0;
		}
		minPath = Integer.MAX_VALUE;
		dfs(triangle,0,0,0);
		return minPath;
	}
	
	private void dfs(List<List<Integer>> triangle,int rows,int index,int sum){
		sum += triangle.get(rows).get(index);
		rows++;
		if(rows<triangle.size()){
			dfs(triangle,rows,index,sum);
			dfs(triangle,rows,index+1,sum);
		}else{
			if(sum < minPath){
				minPath = sum;
			};
		}
		
	}
	//法二 ：dp
	public int minimumTotal2(List<List<Integer>> triangle) {
		if(triangle.size()==0){
			return 0;
		}
		//保存的是，从下倒上，到达每一个元素的最小路径
		int[][] tmp = new int[triangle.size()][triangle.size()];
		//初始化第rows行的元素，这是后面循环的基础
		for(int index=0;index<triangle.get(triangle.size()-1).size();index++){
			tmp[triangle.size()-1][index] = triangle.get(triangle.size()-1).get(index);
		}
		//从下到上，分析到达每个元素的最短路径
		for(int rows=triangle.size()-2;rows>=0;rows--){
			for(int index=0;index<triangle.get(rows).size();index++){
				tmp[rows][index] = triangle.get(rows).get(index)+min(tmp[rows+1][index],tmp[rows+1][index+1]);
			}
		}
		
		return tmp[0][0];
	}

	private int min(int a,int b){
		if(a<b){
			return a;
		}else{
			return b;
		}
	}
	public static void main(String[] args) {
		List<Integer> row0 = new ArrayList<Integer>();
		row0.add(2);
		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(3);
		row1.add(4);
		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(6);
		row2.add(5);
		row2.add(7);
		List<Integer> row3 = new ArrayList<Integer>();
		row3.add(4);
		row3.add(1);
		row3.add(8);
		row3.add(3);
		List<List<Integer>> tri = new ArrayList<List<Integer>>(); 
		tri.add(row0);
		tri.add(row1);
		tri.add(row2);
		tri.add(row3);
		Triangle t = new Triangle();
		int res = t.minimumTotal2(tri);
		System.out.println(res);
	}

}
