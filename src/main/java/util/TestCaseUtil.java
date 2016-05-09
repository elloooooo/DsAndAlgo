package util;

import java.util.List;

import dataStructure.ListNode;

public class TestCaseUtil {

	public static <T> String arrayToString(List<T> array){
		StringBuffer sbf = new StringBuffer();
		for(T elem : array){
			sbf.append(elem.toString());
			sbf.append(" ");
		}
		return sbf.toString().trim();
	}
	
	public static String ListNodeToString(ListNode head){
		StringBuffer sbf = new StringBuffer();
		
		while (head != null) {
			sbf.append(head.val);
			sbf.append(" ");
		}
		
		return sbf.toString().trim();
	}
}
