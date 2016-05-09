package dsTest;

import junit.framework.TestCase;
import dataStructure.ListNode;
import dsTest.PartitionList;

public class TestParitionList extends TestCase {

	public TestParitionList(String name) {
		super(name);
	}

	public void testPartition() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		PartitionList p = new PartitionList();
		ListNode res = p.partition(head, 4);
		String expectedRes = "1 2 3";
		assertEquals(expectedRes,  res.toString());
	}
	
	public void testPartition2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);

		PartitionList p = new PartitionList();
		ListNode res = p.partition(head, 2);
		String expectedRes = "1 1";
		assertEquals(expectedRes, res.toString());
	}

	public void testPartition3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		PartitionList p = new PartitionList();
		ListNode res = p.partition(head, 3);
		String expectedRes = "1 2 2 4 3 5";
		assertEquals(expectedRes, res.toString());
	}
}
