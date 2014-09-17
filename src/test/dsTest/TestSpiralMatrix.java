package test.dsTest;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import dsTest.SpiralMatrix;

public class TestSpiralMatrix extends TestCase{
	public TestSpiralMatrix(String name){
		super(name);
	}
	public void testSpiralOrder(){
		int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		List<Integer> expectedRes = new ArrayList<Integer>();
		expectedRes.add(1);
		expectedRes.add(2);
		expectedRes.add(3);
		expectedRes.add(6);
		expectedRes.add(9);
		expectedRes.add(8);
		expectedRes.add(7);
		expectedRes.add(4);
		expectedRes.add(5);
		
		assertEquals(expectedRes, spiralMatrix.spiralOrder(data));
	}
	
	public void testSpiralOrderForNormal(){
		int[][] data = {{1,2,3},{4,5,6},{7,8,9}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		String expectedRes = "1 2 3 6 9 8 7 4 5";
		assertEquals(expectedRes, spiralMatrix.spiralOrderForTest(data));
	}
	
	public void testSpiralOrderForTwoRows(){
		int[][] data = {{1,2,3},{4,5,6}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		String expectedRes = "1 2 3 6 5 4";
		assertEquals(expectedRes, spiralMatrix.spiralOrderForTest(data));
	}
	
	public void testSpiralOrderForTwoCols(){
		int[][] data = {{1,2},{3,4},{5,6}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		String expectedRes = "1 2 4 6 5 3";
		assertEquals(expectedRes, spiralMatrix.spiralOrderForTest(data));
	}
	
	public void testSpiralOrderForOneRow(){
		int[][] data = {{1,2}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		String expectedRes = "1 2";
		assertEquals(expectedRes, spiralMatrix.spiralOrderForTest(data));
	}
	
	public void testSpiralOrderForOneCol(){
		int[][] data = {{1},{2},{3}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		String expectedRes = "1 2 3";
		assertEquals(expectedRes, spiralMatrix.spiralOrderForTest(data));
	}
	
	public void testSpiralOrderForOneElem(){
		int[][] data = {{1}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		String expectedRes = "1";
		assertEquals(expectedRes, spiralMatrix.spiralOrderForTest(data));
	}
	
	public void testSpiralOrderForNone(){
		int[][] data = {};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		String expectedRes = "";
		assertEquals(expectedRes, spiralMatrix.spiralOrderForTest(data));
	}

}
