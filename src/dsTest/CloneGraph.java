package dsTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 */

/**
 * @author Administrator
 * ���ȹ�����ȱ�������ͼ�������еĵ㸴�ƣ���ͨ��hashmap�洢������������label��ֵΪ�õ�
 * 
 * Ȼ����һ�ι�����ȱ�����Ȼ��ÿһ�����neighbor�����е�ֵ�����ȥ����Ϊ��Щ�������ߣ�
 */
public class CloneGraph {

	private static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null){
			return null;
		}
		//�����Ѿ����ֹ���label
		Set<Integer> foundNode = new HashSet<Integer>();
		//���渴�ƺõĽڵ�
		Map<Integer,UndirectedGraphNode> copyNodes = new HashMap<Integer,UndirectedGraphNode>();
		//������ȱ�����Ҫ���нṹ
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		foundNode.add(node.label);
		
		while(!queue.isEmpty()){
			//����
			UndirectedGraphNode curNode = queue.poll();
			//���ƽڵ㲢���浽map��
			copyNodes.put(curNode.label, new UndirectedGraphNode(curNode.label));
			
			for(UndirectedGraphNode neighbor:curNode.neighbors){
				if(!foundNode.contains(neighbor.label)){
					foundNode.add(neighbor.label);
					queue.add(neighbor);
				}
			}
		}
		//�ڶ��ι�����ȱ���
		foundNode.clear();
		queue.add(node);
		foundNode.add(node.label);
		while(!queue.isEmpty()){
			UndirectedGraphNode curNode = queue.poll();
			for(UndirectedGraphNode neighbor:curNode.neighbors){
				//Ϊÿһ��������neighbor
				copyNodes.get(curNode.label).neighbors.add(copyNodes.get(neighbor.label));
				if(!foundNode.contains(neighbor.label)){
					foundNode.add(neighbor.label);
					queue.add(neighbor);
				}
			}
		}
		
		return copyNodes.get(node.label);
	}

	public static void main(String[] args) {
		UndirectedGraphNode ugn = new UndirectedGraphNode(1);
		UndirectedGraphNode ugn1 = new UndirectedGraphNode(2);
		UndirectedGraphNode ugn2 = new UndirectedGraphNode(3);
		
		ugn.neighbors.add(ugn1);
		ugn.neighbors.add(ugn2);
		
		ugn1.neighbors.add(ugn2);
		
		ugn2.neighbors.add(ugn2);
		
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode ccg = cg.cloneGraph(ugn);
		

	}

}
