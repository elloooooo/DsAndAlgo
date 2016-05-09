package dsTest;

import java.util.List;

import junit.framework.TestCase;
import util.TestCaseUtil;
import dsTest.BinaryTreeInorderTraversal;
import dsTest.BinaryTreeInorderTraversal.TreeNode;

public class TestBinaryTreeInorderTraversal extends TestCase {
	public TestBinaryTreeInorderTraversal(String name){
		super(name);
	}
	
	public void testInorderTraversal(){
		BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<Integer> res = b.inorderTraversal(root);
		String actualRes = TestCaseUtil.arrayToString(res);
		String expectedRes = "2 1 3";
		assertEquals(expectedRes, actualRes);
	}
	
	public void testInorderTraversalForOnlyLeftChild(){
		BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		List<Integer> res = b.inorderTraversal(root);
		String actualRes = TestCaseUtil.arrayToString(res);
		String expectedRes = "2 1";
		assertEquals(expectedRes, actualRes);
	}

	
	public void testInorderTraversal2(){
		BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<Integer> res = b.inorderTraversal2(root);
		String actualRes = TestCaseUtil.arrayToString(res);
		String expectedRes = "2 1 3";
		assertEquals(expectedRes, actualRes);
	}
}
