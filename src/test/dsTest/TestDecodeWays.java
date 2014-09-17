package test.dsTest;
import junit.framework.TestCase;
import dsTest.DecodeWays;

public class TestDecodeWays extends TestCase {
	public TestDecodeWays(String name){
		super(name);
	}
	public void testNumDecodingsDP(){
		DecodeWays b = new DecodeWays();
		String s = "1212";
		int actualRes = b.numDecodingsDP(s);
		int expectedRes = 5;
		assertEquals(expectedRes, actualRes);
	}
	
	
}
