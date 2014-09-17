package dsTest;

/**
 * @author Administrator
 *
 * 阿里笔试题，获取test中最长query
 */
public class SubArray {

	public int getMaxLenOfSubString(String query, String text) {
		char[] queryArray = query.toCharArray();
		int maxlen = 0;
		for (int begin = 0; begin < queryArray.length; begin++) {
			StringBuffer sbf = new StringBuffer();
			sbf.append(queryArray[begin]);
			for (int end = begin + 1; end < queryArray.length; end++) {
				sbf.append(queryArray[end]);
				String tmp = sbf.toString();
				if (text.matches(".*"+tmp+".*")) {
					maxlen = tmp.length() > maxlen ? tmp.length() : maxlen;
				}
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {
		String query = "";
		String text = "";
		SubArray s = new SubArray();
		int res = s.getMaxLenOfSubString(query, text);
		System.out.println(res);

	}

}
