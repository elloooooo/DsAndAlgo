package test.dsTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import junit.framework.TestCase;
import dsTest.BinarySearch;

public class TestBinarySearch extends TestCase{

	public TestBinarySearch(String name){
		super(name);
	}
	public void testFind() throws Exception{
		String line;
		int lineNum = 0;
		BufferedReader bdr = new BufferedReader(new FileReader("source/testData/binarySearchTestData.txt"));
		while((line = bdr.readLine())!= null){
			lineNum ++;
			if(line.startsWith("#")){
				continue;
			}
			StringTokenizer st = new StringTokenizer(line);
			if(!st.hasMoreTokens()){
				continue;
			}
			String val = st.nextToken();
			int expected = Integer.parseInt(val);
			
			String param = st.nextToken();
			int target = Integer.parseInt(param);
			
			List<String> argumentList = new ArrayList<String>();
			while(st.hasMoreTokens()){
				argumentList.add(st.nextToken());
			}
			int[] arguments = new int[argumentList.size()];
			for(int i=0;i<argumentList.size();i++){
				arguments[i] = Integer.parseInt(argumentList.get(i));
			}
			
			BinarySearch b = new BinarySearch();
			assertEquals(expected, b.find(arguments, target));
			
			System.out.println("Test in "+lineNum+" passed!");
			
		}
	}
}
