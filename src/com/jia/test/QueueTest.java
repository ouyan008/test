package com.jia.test;

import com.jia.test.LinkedListTest;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue();
		for (int i = 0; i < 5; i++) {
			queue.insert(i);
			System.out.println(queue);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(queue.delete());
			System.out.println(queue);
			
		}
		
		System.out.println(queue.getHead());
		System.out.println(queue.getTail());

	}

}


class MyQueue<T> {
	
	Node<T> head, tail;
	
	public Node<T> getHead() {
		return head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void insert (T data) {
		
		if (tail == null) {
			head = new Node<T>(data);
			tail = head;
		} else {
			Node<T> oldTail = tail;
			tail = new Node<T>(data);
			oldTail.setNext(tail);
		}
		
	}
	
	public T delete () {
		
		if (head == null) throw new RuntimeException("Empty Stack");
		Node<T> oldHead = head;
		head = head.getNext();
		if (head == null) tail = null;
		return  oldHead.getData();
		
	}
	
	public T peek() {
		if (head == null) throw new RuntimeException("Empty Stack");
		return head.getData();
	}
	
	
public String toString() {
		
		String str = "";
		Node<T> current = head; 
		while (current != null) {
			str = current.getData() + "|" +str;
			current = current.getNext();
			
		}
		return str;
	}
	
}