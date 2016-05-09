package dsTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 */


/**
 * 利用一个双向链表保存Key的优先顺序，一个HashMap保存key=>value的映射关系
 * 
 * 每当访问一个key，如果key不在HashMap中，则将其加入HashMap，并将其存于链表头部，
 * 并将该key对应元素置于链表头部
 * 如果链表超长，则删除链表尾部最后一个元素（用双向链表就是这个原因，否则要遍历到链表尾才能得到最后的元素）
 *
 */
public class LRUCache {
	private Map<Integer, Integer> map;
	private int capacity;
	private ListNode<Integer> head;
	private ListNode<Integer> tail;

	private static class ListNode<Integer> {
		private ListNode<Integer> next;
		private ListNode<Integer> prev;
		private Integer val;

		public ListNode(Integer x) {
			val = x;
			next = null;
			prev = null;
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head = null;
		this.tail = null;
		this.map = new HashMap();
	}
	public synchronized int get(int key) {
		int res = -1;
		if (map.containsKey(key)) {
			res = (Integer) map.get(key);
			putNodeToHead(key,true);
		}
		return res;
	}
	
	

	public synchronized void set(int key, int value) {
		if (map.containsKey(key)) {
			int oldvalue = map.get(key);
			map.put(key, value);
			putNodeToHead(key,true);
		} else {
			map.put(key, value);
			if (map.size() > this.capacity) {//如果链表超过容量限制
				int oldkey = tail.val;
				map.remove(oldkey);
				putNodeToHead(key,false);
				deleteTailNode();
				
			} else {
				putNodeToHead(key,false);
			}

		}
	}

	/**
	 * 删除末尾节点
	 */
	private void deleteTailNode() {
		if(tail!=null){
			if(tail.prev!=null){
				tail = tail.prev;
				tail.next = null;
			}
		}
	}

	
	/**
	 * @param nodeVal 节点值
	 * @param isInList 该节点值是否已在链表中存在
	 * 将值为nodeVal的节点，至于链表头
	 */
	private void putNodeToHead(int nodeVal,boolean isInList){
		ListNode node = new ListNode(nodeVal);
		if(head==null){
			head = node;
			tail = node;
		}else{
			node.next = head;
			head.prev = node;
			head = node;
			if(isInList){
				ListNode cur = head.next;
				while(cur!=null){
					if((Integer)cur.val == nodeVal){
						if(cur.next!=null){
							cur.prev.next = cur.next;
							cur.next.prev = cur.prev;
						}else{
							tail = cur.prev;
							tail.next = null;
							if(cur.prev.prev!=null){
								tail.prev = cur.prev.prev;
								
							}else{
								tail.prev = null;
							}
						}
						break;
					}
					cur = cur.next;
				}
			}
		}
	}
	
	
	public void printCache(){
		System.out.println("===========================");
		if(head ==null){
			System.out.println("list is empty");
		}else{
			ListNode cur = head;
			while(cur!=null){
				System.out.println(cur.val);
				cur = cur.next;
			}
		}
		
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.printCache();

		
		cache.set(1,1);
		cache.printCache();
		cache.set(2, 3);
		cache.printCache();
		cache.set(4, 1);
		cache.printCache();
		System.out.println(cache.get(1));
		cache.printCache();
		System.out.println(cache.get(2));
		cache.printCache();
		
	}

}
