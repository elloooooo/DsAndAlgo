package dsTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * 读入一个文件，找出该文件中含有“your”的行（不区分大小写）；
 * 并根据每一行出现your的频率排序，出现your最多的排在前面
 */
public class FindLineWithWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String line;
		try {
			BufferedReader bdr = new BufferedReader(new FileReader("source/test.txt"));
			Map<String,Integer> map = new HashMap<String,Integer>();
			while ((line = bdr.readLine()) != null) {
				Pattern p = Pattern.compile("(?i)your");
				Matcher m = p.matcher(line);
				int i=0;
				while(m.find()){
					map.put(line, ++i);
				}
			}
			
			Set<Entry<String, Integer>> entrySet = map.entrySet();
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(entrySet);
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
				@Override
				public int compare(Entry<String, Integer> o1,
						Entry<String, Integer> o2) {
					if(o1.getValue()>o2.getValue()){
						return -1;
					}else if(o1.getValue()<o2.getValue()){
						return 1;
					}else{
						return 0;
					}
				}
			});
			
			for(Entry<String, Integer> entry:list){
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
