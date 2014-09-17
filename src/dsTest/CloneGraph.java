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
 * 首先广度优先遍历整个图，将所有的点复制，并通过hashmap存储起来，键就是label，值为该点
 * 
 * 然后再一次广度优先遍历，然后将每一个点的neighbor属性中的值加入进去，即为这些点做连线！
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
		//储存已经发现过的label
		Set<Integer> foundNode = new HashSet<Integer>();
		//储存复制好的节点
		Map<Integer,UndirectedGraphNode> copyNodes = new HashMap<Integer,UndirectedGraphNode>();
		//广度优先遍历需要队列结构
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		foundNode.add(node.label);
		
		while(!queue.isEmpty()){
			//出队
			UndirectedGraphNode curNode = queue.poll();
			//复制节点并储存到map中
			copyNodes.put(curNode.label, new UndirectedGraphNode(curNode.label));
			
			for(UndirectedGraphNode neighbor:curNode.neighbors){
				if(!foundNode.contains(neighbor.label)){
					foundNode.add(neighbor.label);
					queue.add(neighbor);
				}
			}
		}
		//第二次广度优先遍历
		foundNode.clear();
		queue.add(node);
		foundNode.add(node.label);
		while(!queue.isEmpty()){
			UndirectedGraphNode curNode = queue.poll();
			for(UndirectedGraphNode neighbor:curNode.neighbors){
				//为每一个点增加neighbor
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
