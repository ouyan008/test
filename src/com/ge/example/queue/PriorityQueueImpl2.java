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

public class PriorityQueueImpl2<T> implements PriorityQueue<T> {
	
	Node<T> head = null;
	
	public PriorityQueueImpl2 (int s) {
		
		
		
	}
	
    public PriorityQueueImpl2 () {
		
				
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
				Node newNode =  new Node <T> (null, head, value, priority);
				head.prev = newNode;
				head = newNode; 
				return true;
			} else {			
			Node <T> currentNode = head;
			while (currentNode.next!= null) {									
				System.out.println("yyy");
				if (priority <= currentNode.priority){
					currentNode.prev.next =  new Node <T> (currentNode.prev, currentNode, value, priority);
					return true;
				}
				currentNode = currentNode.next;
			}
				
                   System.out.println("xxx");		
                   if (priority <= currentNode.priority) {
                	   currentNode.prev.next =  new Node <T> (currentNode.prev, currentNode, value, priority);
                   } else {
                	   currentNode.next = new Node <T> (currentNode, null, value, priority);
                	   return true;
                   }
                   
			}
		}
		
		return false;
	}
	
	
	class Node <T> {
		
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



	



