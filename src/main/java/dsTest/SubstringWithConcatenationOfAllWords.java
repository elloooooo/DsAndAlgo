package dsTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L.length == 0) {
			return res;
		}
		//保存单词字典，以及每一个元素可以出现的次数
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String elem : L) {
			if (map.containsKey(elem)) {
				map.put(elem, map.get(elem) + 1);
			} else {
				map.put(elem, 1);
			}
		}
		int wordLen = L[0].length();
		int wordNum = L.length;
		//找到第一个元素
		for (int i = 0; i <= S.length() - wordNum * wordLen; i++) {
			int begin = i;
			int end = i;
			String first = S.substring(i, i + wordLen);
			//纪录每一个元素还可以出现的次数，每次循环用map初始化
			Map<String, Integer> _map = new HashMap<String, Integer>(map);
			if (map.containsKey(first)) {
				end += wordLen;
				_map.put(first, _map.get(first) - 1);
				int curwordNum = 1;
				//如果单词个数只有一个，要判断找到的第一个元素是否就是满足要求的元素
				if (curwordNum == wordNum) {
					res.add(begin);
					continue;
				}
				//找到第一个元素后，找后面的元素
				for (int k = end; k <= S.length() - wordLen; k += wordLen) {
					String tmp = S.substring(k, k + wordLen);
					//包含在单词字典中，且仍可以出现的元素，就是合法的元素
					if (map.containsKey(tmp) && _map.get(tmp) != 0) {
						end += wordLen;
						_map.put(tmp, _map.get(tmp) - 1);
						curwordNum++;
						//如果当前已经发现的合法元素个数达到字典长度，则将其开始元素下标加入res，并跳出循环，从下一个开始位置找合法的元素
						if (curwordNum == wordNum) {
							res.add(begin);
							break;
						}
					} else {
						//如果不在字典中，或者已经不可以在出现的元素被发现，则跳出循环，从下一个开始位置找合法的元素
						break;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String test = "mississippi";
		String[] L = { "is" };
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		List<Integer> res = s.findSubstring(test, L);
		for (Integer elem : res) {
			System.out.println(elem);
		}
	}

}
