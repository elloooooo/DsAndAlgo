package dsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		List<Integer> numArray =new ArrayList<Integer>();
		//将数列放入list，为了使用Collections的sort功能
		for(int i=0;i<numbers.length;i++){
			numArray.add(numbers[i]);
		}
		//复制一个新的list去排序
		List<Integer> sortedArray = new ArrayList<Integer>(numArray);
		//排序
		Collections.sort(sortedArray);
		
		int i = 0,j = numArray.size()-1;
		while(i<j){
			if(sortedArray.get(i)+sortedArray.get(j)>target){
				j--;
			}else if(sortedArray.get(i)+sortedArray.get(j)<target){
				i++;
			}else{
				
				int[] res = new int[2];
				
				int index1 = numArray.indexOf(sortedArray.get(i))+1;
				int index2 = 0;
				//如果两个值相同，则要去掉第一个值，求第二个值得下标
				if(sortedArray.get(i)==sortedArray.get(j)){
					numArray.remove(index1-1);
					index2 = numArray.indexOf(sortedArray.get(j))+2;
				}else{
					index2 = numArray.indexOf(sortedArray.get(j))+1;
				}
				if(index1>index2){
					res[0] = index2;
					res[1] = index1;
				}else{
					res[0] = index1;
					res[1] = index2;
				}
				return res;
			}
		}
		
		return null;
	}

	private static class Node implements Comparable<Node>{
		int pos,val;

		@Override
		public int compareTo(Node o) {
			return this.val-o.val;
		}
	}
	
	public int[] twoSumII(int[] numbers, int target) {
		List<Node> nodes = new ArrayList<Node>();
		for(int i=0;i<numbers.length;i++){
			Node _node = new Node();
			_node.pos = i;
			_node.val = numbers[i];
			nodes.add(_node);
		}

		Collections.sort(nodes);
		int begin=0,end=nodes.size()-1;
		while(begin<end){
			if(nodes.get(begin).val+nodes.get(end).val>target){
				end--;
			}else if(nodes.get(begin).val+nodes.get(end).val<target){
				begin++;
			}else{
				break;
			}
		}
		
		int[] res = new int[2];
		if(nodes.get(begin).pos>nodes.get(end).pos){
			res[0] = nodes.get(end).pos+1;
			res[1] = nodes.get(begin).pos+1;
		}else{
			res[0] = nodes.get(begin).pos+1;
			res[1] = nodes.get(end).pos+1;
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		int[] numbers = { 0,4,3,0};
		TwoSum t = new TwoSum();
		int[] res = t.twoSumII(numbers, 0);
		for (int elem : res) {
			System.out.println(elem);
		}
	}

}
