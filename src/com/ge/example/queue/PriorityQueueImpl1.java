/*Title: Priority Queue

Problem
============================
- We've started a class (PriorityQueue) that you need to finish implementing (see TODOs).
  Intended behavior of each method is described in its corresponding comment.

- We've included a small unit test for you as a sanity check ;)
  If needed, add more unit tests to the TreeNodeTest class

*/



package com.ge.example.queue;

import java.util.NoSuchElementException;

public class PriorityQueueImpl1<T> implements PriorityQueue<T> {
	
	Node<T> head = null;
	
	public PriorityQueueImpl1 (int s) {
		
		
		
	}
	
    public PriorityQueueImpl1 () {
		
				
	}
	

	@Override
	public boolean isEmpty() {
		
		return (head == null );
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getNext() throws NoSuchElementException {
		if (head == null ) throw new NoSuchElementException();
		Node <T> highNode = head;
		head = head.next;
		System.out.println("item: " + highNode.item);
		return (T) highNode.item;
	}

	@Override
	public boolean add(T value, int priority) {
		
		if (head == null) {
			head = new Node <T> (null, value, priority);
			System.out.println("xxx" + priority);
		} 
		else {
			if (priority <= head.priority){
				head = new Node <T> (head, value, priority);
				System.out.println("ccc" + priority + head.item);
				return true;
			}
			
			Node <T> currentNode = head;
			Node <T> prevNode = null;
			
			while (currentNode != null) {			
				
				
				if (priority <= currentNode.priority){
					prevNode.next =  new Node <T> (currentNode, value, priority);
					System.out.println("valuexxx" + priority);
					return true;
				}
				
				if (currentNode.next == null) {
					currentNode.next = new Node <T> (null, value, priority);
					System.out.println("yyy" + priority);
					return true;
				}
				prevNode = currentNode;
				currentNode = currentNode.next;
				
			}
							
		}
		
		return false;
	}
	
	
	static class Node <T> {
				
		public Node(Node next, T item, int priority) {
			super();
			this.next = next;
			this.item = item;
			this.priority = priority;
		}

		Node next;
		T item;
		int priority;
			
	}
	
	
	}



	



