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

public class PriorityQueueImpl<T> implements PriorityQueue<T> {
	
	Node<T> head = null;
	
	public PriorityQueueImpl (int s) {
		
		
		
	}
	
    public PriorityQueueImpl () {
		
				
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
		return (T) highNode.item;
	}

	@Override
	public boolean add(T value, int priority) {
		
		if (head == null) {
			head = new Node <T> (null, null, value, priority);
		} else {
			if (priority <= head.priority) {
				head = new Node <T> (null, head, value, priority);
				return true;
			} 			
			Node <T> currentNode = head;
			while (currentNode.next != null) {			
				if (priority <= currentNode.next.priority){
					Node <T> nextNode = currentNode.next;
					currentNode.next =  new Node <T> (currentNode, nextNode, value, priority);
					nextNode.prev =  currentNode.next;
					return true;
				}
				currentNode = currentNode.next;
			}
			if (priority <= currentNode.priority) {		
				Node <T> newNode = new Node (currentNode.prev, currentNode.next, value, priority);
				currentNode.prev.next = newNode;
				currentNode.prev = newNode;
				return true;
			} else {
				currentNode.next = new Node (currentNode, null, value, priority);
				return true;
			}
		}
		
		return false;
	}
	
	
	private static class Node <T> {
		
		public Node(Node prev, Node next, T item, int priority) {
			super();
			this.prev = prev;
			this.next = next;
			this.item = item;
			this.priority = priority;
		}
		Node prev;
		Node next;
		T item;
		int priority;
			
	}
	
	
	}



	



