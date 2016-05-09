package dsTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given:
 * 
 * start = "hit"
 * 
 * end = "cog"
 * 
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
	private static class GraphNode {
		private String val;
		private int distence;

		public GraphNode(String x) {
			val = x;
		}
	}

	public int ladderLength(String start, String end, Set<String> dict) {
		dict.add(start);
		dict.add(end);
		
		//Ϊÿһ��Ԫ������һ��ͼ�ص�
		Map<String, GraphNode> nodes = new HashMap<String, GraphNode>();
		for (String node : dict) {
			nodes.put(node, new GraphNode(node));
		}

		nodes.get(start).distence = 1;
		//�����ֵĽڵ��Լ����У�BFS��Ҫ�����ݽṹ
		Set<String> foundNode = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);

		while (!queue.isEmpty()) {
			String parent = queue.poll();
			//�������ص㣬��Ϊԭ��ʹ������forѭ��ȥ�����ڽӱ�ȥ����ͼ��������Ϣ�ķ������Ӷ�n^2,
			//������ʹ�øĽ��ķ�ʽ������ȥѰ��parent�ڵ����ת���Ľڵ�
			//���ý�ÿһλ�ַ��滻Ϊa-z�����Ƿ�������ֵ��У����Ӷ� Ԫ�س���*26
			for (int i = 0; i < parent.length(); i++) {
				for (char j = 'a'; j < 'z'; j++) {
					if (parent.charAt(i) == j) {
						continue;
					}
					StringBuilder sb = new StringBuilder(parent);
					sb.setCharAt(i, j);
					
					if(sb.toString().equals(end)){
						return nodes.get(parent).distence + 1;
					}
					
					if(dict.contains(sb.toString())){
						if (!foundNode.contains(sb.toString())) {
							foundNode.add(sb.toString());
							queue.add(sb.toString());
							nodes.get(sb.toString()).distence = nodes.get(parent).distence + 1;
						}
					}
				}
			}

		}

		return 0;
	}

	public static void main(String[] args) {
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String>();
		String[] dictArray = { "a", "b", "c"};
		for (int i = 0; i < dictArray.length; i++) {
			dict.add(dictArray[i]);
		}

		WordLadder w = new WordLadder();
		int min = w.ladderLength(start, end, dict);
		System.out.println(min);
	}

}
