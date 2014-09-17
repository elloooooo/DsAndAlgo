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
		//���浥���ֵ䣬�Լ�ÿһ��Ԫ�ؿ��Գ��ֵĴ���
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
		//�ҵ���һ��Ԫ��
		for (int i = 0; i <= S.length() - wordNum * wordLen; i++) {
			int begin = i;
			int end = i;
			String first = S.substring(i, i + wordLen);
			//��¼ÿһ��Ԫ�ػ����Գ��ֵĴ�����ÿ��ѭ����map��ʼ��
			Map<String, Integer> _map = new HashMap<String, Integer>(map);
			if (map.containsKey(first)) {
				end += wordLen;
				_map.put(first, _map.get(first) - 1);
				int curwordNum = 1;
				//������ʸ���ֻ��һ����Ҫ�ж��ҵ��ĵ�һ��Ԫ���Ƿ��������Ҫ���Ԫ��
				if (curwordNum == wordNum) {
					res.add(begin);
					continue;
				}
				//�ҵ���һ��Ԫ�غ��Һ����Ԫ��
				for (int k = end; k <= S.length() - wordLen; k += wordLen) {
					String tmp = S.substring(k, k + wordLen);
					//�����ڵ����ֵ��У����Կ��Գ��ֵ�Ԫ�أ����ǺϷ���Ԫ��
					if (map.containsKey(tmp) && _map.get(tmp) != 0) {
						end += wordLen;
						_map.put(tmp, _map.get(tmp) - 1);
						curwordNum++;
						//�����ǰ�Ѿ����ֵĺϷ�Ԫ�ظ����ﵽ�ֵ䳤�ȣ����俪ʼԪ���±����res��������ѭ��������һ����ʼλ���ҺϷ���Ԫ��
						if (curwordNum == wordNum) {
							res.add(begin);
							break;
						}
					} else {
						//��������ֵ��У������Ѿ��������ڳ��ֵ�Ԫ�ر����֣�������ѭ��������һ����ʼλ���ҺϷ���Ԫ��
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
