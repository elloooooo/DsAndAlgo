package dsTest;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() > 12 || s.length() < 4) {
			return res;
		}
		dfs(s, 1, "", res);
		return res;

	}

	private void dfs(String s, int num, String ip, List<String> list) {
    	if (s == null || s.length() == 0) return;
    	if (num == 4 && valid(s)) {
    		ip += s;
    		list.add(ip);
    		return;
    	}
    	for (int i = 1; i <= 3; i++) {
    		if (i > s.length()) break;
    		String pre = s.substring(0, i);
    		if (valid(pre)) {
    			String post = s.substring(i);
    			dfs(post, num + 1, ip + pre + ".", list);
    		}
    	}
    }
	
	private boolean valid(String s) {
	    	if (s == null || s.length() == 0) return false;
	    	if (s.length() > 1 && s.charAt(0) == '0') return false;
	    	int v = Integer.parseInt(s);
	    	if (v >= 0 && v <= 255) return true;
	    	return false;
	    }
	 

	public static void main(String[] args) {
		String s = "010010";
		RestoreIPAddresses r = new RestoreIPAddresses();
		List<String> res = r.restoreIpAddresses(s);
	}

}
