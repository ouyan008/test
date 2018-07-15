package com.ge.example.queue;

import java.util.NoSuchElementException;

public class PriorityQueueImpl5<T> implements PriorityQueue<T> {

	Node head = null;
	Node tail = null;
	int size = 0;

	@Override
	public boolean isEmpty() {
        if (size == 0 ) {
		return true;
	} 
		return false;
	
	}

	@Override
	public T getNext() throws NoSuchElementException {
		if (size == 0 ) {
			throw new NoSuchElementException();
		}	
		T value = (T) head.value;
		head = head.next;
		size--;
		return value;
	}

	@Override
	public boolean add(T value, int priority) {
		Node newnode = new Node(value, priority);
		if (size == 0) {
	     head = newnode;
	     size++;
			return true;
		}

		Node node = head;
		
			
		while (node != null) {
		     System.out.println("size: " + size);
			if (priority < node.priority) {
				addBefore(node, newnode);
				return true;
			}
         	
		if (node.next == null) {
			System.out.println("sssss");
			node.next = newnode;
			newnode.prev = node;
	        size++;
	        break;
		}
		  node = node.next;	
		}
		return true;
	}

	

	private void delete(Node node) {

		node.next.prev = node.prev;
		node.prev.next = node.next;
		size--;
		node.next = null;
		node.prev = null;

	}

	private void addBefore(Node node, Node newnode) {
		
		
		if (node == head) {
			
			head = newnode;
			head.next = node;
			node.prev = newnode;
			System.out.println("here");
			size++;
			return;
			
			
		}
       
		
		newnode.next = node;
		node.prev.next = newnode;
		node.prev = newnode;
		newnode.prev = node.prev;
		 tail = node;
		size++;
	}

	static class Node<T> {

		T value;

		public Node(T value, int priority) {

			this.value = value;
			this.priority = priority;

		}

		int priority;
		Node next = null;
		Node prev = null;

	}

	public int getSize() {
		return size;
	}
	
	@Override
	public String toString () {
		Node node = head;
		StringBuffer sb = new StringBuffer();
		while (node != null) {
			sb.append(node.value.toString() + " ");
			node = node.next;
		}
		return sb.toString();
		
	}

}
